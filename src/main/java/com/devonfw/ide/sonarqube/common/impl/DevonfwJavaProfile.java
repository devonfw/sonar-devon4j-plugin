package com.devonfw.ide.sonarqube.common.impl;

import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.AnnotationUtils;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;

/**
 * This class creates a quality profile containing the rules of this plugin.
 */
@SonarLintSide
public class DevonfwJavaProfile implements BuiltInQualityProfilesDefinition {

  @Override
  public void define(Context context) {

    NewBuiltInQualityProfile devonfwJava = context.createBuiltInQualityProfile("devonfw Java", "java");
    Rule ruleAnnotation;

    for (Class<? extends JavaCheck> check : DevonSonarRegistrar.checkClasses()) {

      ruleAnnotation = AnnotationUtils.getAnnotation(check, Rule.class);
      devonfwJava.activateRule(DevonSonarDefinition.REPOSITORY_KEY, ruleAnnotation.key());
    }

    devonfwJava.setDefault(true);
    devonfwJava.done();
  }

}