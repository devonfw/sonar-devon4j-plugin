package com.devonfw.ide.sonarqube.common.impl.check;

/**
 * Abstract base class for all SonarQube 3rd party dependency checks of this plugin.
 */
public abstract class DevonArchitecture3rdPartyCheck extends DevonArchitectureCheck {

  @Override
  protected boolean isCheckDependencyOnInvalidPackage() {

    return true;
  }

}
