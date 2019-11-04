package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Architecture;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentCheck;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a {@link Component} itself is properly defined in
 * {@link Architecture} and that the general {@link Component#getDependencies() dependencies} are not violated.
 */
@Rule(key = "Devon4j:C2", name = "Devon Component Dependency Check", //
    description = "Verify component only depends on components of declared dependencies from architecture.json file.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "component" })
public class DevonArchitectureComponentDependencyCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String targetDependencyNotAllowed(Component sourceComponent, String targetComponentName) {

    String sourceComponentName = sourceComponent.getName();

    return "Access from component '" + sourceComponentName + "' to '" + targetComponentName + "' is not allowed. From '"
        + sourceComponentName + "', only dependencies to the following components are allowed: "
        + sourceComponent.allDependencies() + "";
  }

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    return null;
  }

}
