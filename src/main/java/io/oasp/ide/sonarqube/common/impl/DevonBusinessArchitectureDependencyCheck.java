package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.ide.sonarqube.common.api.config.Component;
import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */
@Rule(key = "DevonBusinessArchitectureDependencyCheck", name = "Devon Scope API-Impl Check", description = "Verify that the code from API package does not depend on code from implementation package.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonBusinessArchitectureDependencyCheck extends DevonBusinessArchitectureCheck {

  @Override
  protected String createIssueForSourcePackage(OaspPackage pkg) {

    String sourceComponentName = pkg.getComponent();
    Component sourceComponent = getComponent(sourceComponentName);
    if (sourceComponent == null) {
      return "Undefined component '" + sourceComponentName
          + "' - please configure business architecture in config JSON.";
    }

    return super.createIssueForSourcePackage(pkg);
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
