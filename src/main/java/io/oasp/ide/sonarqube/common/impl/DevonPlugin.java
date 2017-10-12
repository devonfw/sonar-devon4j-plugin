package io.oasp.ide.sonarqube.common.impl;

import org.sonar.api.Plugin;

/**
 * {@link Plugin} that registeres the Devon rules in SonarQube.
 */
public class DevonPlugin implements Plugin {

  @Override
  public void define(Context context) {

    context.addExtension(DevonSonarDefinition.class);
    context.addExtension(DevonSonarRegistrar.class);
  }

}
