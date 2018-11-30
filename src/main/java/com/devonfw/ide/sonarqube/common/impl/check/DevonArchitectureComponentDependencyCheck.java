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
@Rule(key = "Devon4j:C2", name = "Devon Component Dependency Check", //
    description = "Verify component only depends on components of declared dependencies from architecture.json file.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureComponentDependencyCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String targetDependencyNotAllowed(Component sourceComponent, String targetComponentName) {

    return "Access from component '" + sourceComponent.getName() + "' to '" + targetComponentName
        + "' is not allowed. Only the following components are allowed dependencies: "
        + sourceComponent.transitiveDependencies() + "";
  }

  @Override
  protected String checkDependency(Devon4jPackage source, Component sourceComponent, Devon4jPackage target,
      String targetTypeSimpleName) {

    return null;
  }

}
