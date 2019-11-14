package com.devonfw.ide.sonarqube.common.impl;

import org.sonar.api.SonarRuntime;
import org.sonar.api.utils.AnnotationUtils;
import org.sonar.plugins.java.JavaSonarWayProfile;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;

/**
 * @author lniazman
 *
 */
@SonarLintSide
public class DevonfwJavaProfile extends JavaSonarWayProfile {

  /**
   * The constructor.
   *
   * @param sonarRuntime contains information about runtime environment
   */
  public DevonfwJavaProfile(SonarRuntime sonarRuntime) {

    super(sonarRuntime);
  }

  @Override
  public void define(Context context) {

    super.define(context);

    NewBuiltInQualityProfile devonfwJava = context.createBuiltInQualityProfile("Devonfw Java", "java");
    for (Class<? extends JavaCheck> check : DevonSonarRegistrar.checkClasses()) {
      org.sonar.check.Rule ruleAnnotation = AnnotationUtils.getAnnotation(check, org.sonar.check.Rule.class);
      devonfwJava.activateRule(DevonSonarDefinition.REPOSITORY_KEY, ruleAnnotation.key());
    }

    devonfwJava.done();
  }

}
