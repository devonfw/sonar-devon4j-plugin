package com.devonfw.ide.sonarqube.common.impl;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;
import org.sonar.api.utils.AnnotationUtils;
import org.sonar.plugins.java.Java;
import org.sonar.plugins.java.api.JavaCheck;

import com.google.common.io.Resources;

/**
 * {@link RulesDefinition} for this plugin.
 */
public class DevonSonarDefinition implements RulesDefinition {

  /** Constant for the repository key used as unique ID. */
  public static final String REPOSITORY_KEY = "devon4j";

  private static final String RESOURCE_BASE_PATH = "/com/devonfw/ide/sonarqube/common/rules/devon4j";

  @Override
  public void define(Context context) {

    NewRepository repository = context.createRepository(REPOSITORY_KEY, Java.KEY).setName("devonfw Java Rules");

    for (Class<? extends JavaCheck> check : DevonSonarRegistrar.checkClasses()) {
      addRule(repository, check);
    }

    repository.done();
  }

  private void addRule(NewRepository repository, Class<?> ruleClass) {

    new RulesDefinitionAnnotationLoader().load(repository, ruleClass);
    org.sonar.check.Rule ruleAnnotation = AnnotationUtils.getAnnotation(ruleClass, org.sonar.check.Rule.class);
    if (ruleAnnotation == null) {
      throw new IllegalArgumentException("No Rule annotation was found on " + ruleClass);
    }

    String ruleKey = ruleAnnotation.key();
    if (StringUtils.isEmpty(ruleKey)) {
      throw new IllegalArgumentException("No key is defined in Rule annotation of " + ruleClass);
    }

    NewRule rule = repository.rule(ruleKey);
    if (rule == null) {
      throw new IllegalStateException("No rule was created for " + ruleClass + " in " + repository.key());
    }

    rule.setName(ruleAnnotation.name());
    rule.setSeverity(ruleAnnotation.priority().toString());

    String[] tags = ruleAnnotation.tags();
    boolean hasSecurityTag = false;
    for (int i = 0; i < tags.length; i++) {
      tags[i] = tags[i].toLowerCase(Locale.US);
      if (tags[i].equals("security")) {
        hasSecurityTag = true;
      }
    }
    rule.setTags(tags);

    if (hasSecurityTag) {
      rule.setType(RuleType.VULNERABILITY);
    } else {
      rule.setType(RuleType.CODE_SMELL);
    }

    String ruleHtmlDescription = readRuleHtml(ruleKey);
    if (ruleHtmlDescription == null) {
      throw new IllegalStateException("No HTML configuration was found for " + ruleKey);
    }
    rule.setHtmlDescription(ruleHtmlDescription);

    rule.setStatus(RuleStatus.valueOf(ruleAnnotation.status().toUpperCase(Locale.US)));
  }

  private String readRuleHtml(String ruleKey) {

    URL resource = DevonSonarDefinition.class.getResource(RESOURCE_BASE_PATH + "/" + ruleKey + "_java.html");
    return readResource(resource);
  }

  private static String readResource(URL resource) {

    try {
      return Resources.toString(resource, StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read: " + resource, e);
    }
  }

}
