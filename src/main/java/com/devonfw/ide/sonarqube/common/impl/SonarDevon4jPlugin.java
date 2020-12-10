package com.devonfw.ide.sonarqube.common.impl;

import org.sonar.api.Plugin;

/**
 * The {@link Plugin} to integrate devonfw architecture rules into SonarQube.
 */
public class SonarDevon4jPlugin implements Plugin {

  @Override
  public void define(Context context) {

    context.addExtensions(DevonSonarDefinition.class, DevonSonarRegistrar.class, DevonfwJavaProfile.class);
  }
}
