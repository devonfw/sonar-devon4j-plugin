package io.oasp.ide.sonarqube.common.impl;

import io.oasp.ide.sonarqube.common.api.config.Component;
import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */
public class DevonBusinessArchitectureDependencyCheck extends DevonBusinessArchitectureCheck {

  @Override
  protected String sourceComponentUndefined(String sourceComponentName) {

    return "Undefined component '" + sourceComponentName + "' - please configure business architecture in config JSON.";
  }

  @Override
  protected String targetDependencyNotAllowed(Component sourceComponent, String targetComponentName) {

    return "Access from component '" + sourceComponent.getName() + "' to '" + targetComponentName
        + "' is not allowed. Only the following components are allowed dependencies: "
        + sourceComponent.getDependencies() + "";
  }

  @Override
  protected String checkDependency(OaspPackage source, Component sourceComponent, OaspPackage target,
      String targetTypeSimpleName) {

    return null;
  }

}
