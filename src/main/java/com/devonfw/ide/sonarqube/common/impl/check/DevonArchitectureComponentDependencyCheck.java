package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Architecture;
import com.devonfw.ide.sonarqube.common.api.config.Component;

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
        + sourceComponent.allDependencies() + "";
  }

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    return null;
  }

}
