package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.config.Architecture;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a {@link Component} itself is properly defined in
 * {@link Architecture} and that the general {@link Component#getDependencies() dependencies} are not violated.
 */
@Rule(key = "DevonArchitectureComponentDependencyCheck", name = "Devon Component Dependency Check", description = "Verify component is defined and only depends on components of declared dependencies (configured via architecture.json).", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureComponentDependencyCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String createIssueForInvalidSourcePackage(Devon4jPackage pkg) {

    if (pkg.isValid()) {
      String sourceComponentName = pkg.getComponent();
      Component sourceComponent = getComponent(sourceComponentName);
      if (sourceComponent == null) {
        return "Undefined component '" + sourceComponentName
            + "' - please configure business architecture in config JSON.";
      }
    }
    return super.createIssueForInvalidSourcePackage(pkg);
  }

  @Override
  protected String targetDependencyNotAllowed(Component sourceComponent, String targetComponentName) {

    return "Access from component '" + sourceComponent.getName() + "' to '" + targetComponentName
        + "' is not allowed. Only the following components are allowed dependencies: "
        + sourceComponent.getDependencies() + "";
  }

  @Override
  protected String checkDependency(Devon4jPackage source, Component sourceComponent, Devon4jPackage target,
      String targetTypeSimpleName) {

    return null;
  }

}
