package com.devonfw.ide.sonarqube.common.impl;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;
import org.sonar.api.utils.AnnotationUtils;
import org.sonar.plugins.java.Java;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonar.squidbridge.annotations.RuleTemplate;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyDatatypeMappingsCheck;

/**
 * {@link RulesDefinition} for this plugin.
 */
public class DevonSonarDefinition implements RulesDefinition {

  /** Constant for the repository key used as unique ID. */
  public static final String REPOSITORY_KEY = "devon-java";

  @Override
  public void define(Context context) {

    NewRepository repository = context.createRepository(REPOSITORY_KEY, Java.KEY).setName("Devon Java Rules");

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
    for (int i = 0; i < tags.length; i++) {
      tags[i] = tags[i].toLowerCase(Locale.US);
    }
    rule.setTags(tags);
    rule.setType(RuleType.CODE_SMELL);
    /*
     *  DELETE AFTER DEBUGGING
     */
    if(ruleClass.equals(DevonArchitecture3rdPartyDatatypeMappingsCheck.class)) {
    	rule.setType(RuleType.BUG);
    }
    /*
     *  DELETE AFTER DEBUGGING
     */
    rule.setStatus(RuleStatus.valueOf(ruleAnnotation.status().toUpperCase(Locale.US)));
    rule.setHtmlDescription(ruleAnnotation.description());
    rule.setTemplate(AnnotationUtils.getAnnotation(ruleClass, RuleTemplate.class) != null);
  }

}
