package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a business {@link Component} (in its service-layer) may not
 * depend on the logic-layer of another {@link Component}.
 */
@Rule(key = "DevonArchitectureComponentLayerServiceLogicCheck", name = "Devon Component Layer Service-Logic Check", description = "Verify that the code from layer Service does not depend on code from layer logic.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureComponentLayerServiceLogicCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Component sourceComponent, Devon4jPackage target,
      String targetTypeSimpleName) {

    if (source.isLayerService() && target.isLayerLogic()) {
      return "Service layer ('" + source.toString()
          + "') shall not call code from logic layer in different component ('" + target.toString() + "').";
    }
    return null;
  }

}
