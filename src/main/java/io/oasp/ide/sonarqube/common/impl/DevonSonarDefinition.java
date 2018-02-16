package io.oasp.ide.sonarqube.common.impl;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;
import org.sonar.api.utils.AnnotationUtils;
import org.sonar.check.Cardinality;
import org.sonar.plugins.java.Java;
import org.sonar.squidbridge.annotations.RuleTemplate;

/**
 * TODO
 */
@SuppressWarnings("deprecation")
public class DevonSonarDefinition implements RulesDefinition {

  public static final String REPOSITORY_KEY = "devon-java";

  @Override
  public void define(Context context) {

    NewRepository repository = context.createRepository(REPOSITORY_KEY, Java.KEY).setName("Devon Java Rules");

    addRule(repository, DevonArchitecturePackageCheck.class);
    addRule(repository, DevonArchitectureScopeApiImplCheck.class);
    addRule(repository, DevonArchitectureLayerDataaccessServiceCheck.class);
    addRule(repository, DevonArchitectureScopeApiBaseCheck.class);
    addRule(repository, DevonArchitectureLayerLogicServiceCheck.class);
    addRule(repository, DevonArchitectureLayerDataaccessLogicCheck.class);
    addRule(repository, DevonArchitectureLayerServiceDataaccessCheck.class);
    addRule(repository, DevonArchitectureComponentLayerCheck.class);
    addRule(repository, DevonArchitectureScopeBaseImplCheck.class);
    addRule(repository, DevonArchitectureScopeBaseBaseCheck.class);
    addRule(repository, DevonArchitectureLayerServiceBatchCheck.class);
    addRule(repository, DevonArchitectureLayerServiceClientCheck.class);
    addRule(repository, DevonArchitectureLayerBatchDataaccessCheck.class);
    addRule(repository, DevonArchitectureLayerClientDataaccessCheck.class);

    // registration a new rule

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
    rule.setType(RuleType.BUG);
    rule.setStatus(RuleStatus.valueOf(ruleAnnotation.status().toUpperCase(Locale.US)));
    rule.setHtmlDescription(ruleAnnotation.description());
    rule.setTemplate(AnnotationUtils.getAnnotation(ruleClass, RuleTemplate.class) != null);
    if (ruleAnnotation.cardinality() == Cardinality.MULTIPLE) {
      throw new IllegalArgumentException(
          "Cardinality is not supported, use the RuleTemplate annotation instead for " + ruleClass);
    }
  }

}
