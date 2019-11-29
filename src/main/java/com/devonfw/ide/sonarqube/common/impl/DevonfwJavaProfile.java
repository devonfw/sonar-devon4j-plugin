package com.devonfw.ide.sonarqube.common.impl;

import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.AnnotationUtils;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;

/**
 * @author lniazman
 *
 */
@SonarLintSide
public class DevonfwJavaProfile implements BuiltInQualityProfilesDefinition {

  @Override
  public void define(Context context) {

    NewBuiltInQualityProfile devonfwJava = context.createBuiltInQualityProfile("Devonfw Java", "java");
    org.sonar.check.Rule ruleAnnotation;

    for (Class<? extends JavaCheck> check : DevonSonarRegistrar.checkClasses()) {

      ruleAnnotation = AnnotationUtils.getAnnotation(check, org.sonar.check.Rule.class);
      devonfwJava.activateRule(DevonSonarDefinition.REPOSITORY_KEY, ruleAnnotation.key());
    }

    devonfwJava.setDefault(true);
    devonfwJava.done();
  }

}