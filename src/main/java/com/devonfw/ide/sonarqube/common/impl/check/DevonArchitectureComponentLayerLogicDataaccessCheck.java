package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a business {@link Component} may not depend on the
 * dataaccess-layer of another {@link Component}.
 */
@Rule(key = "DevonArchitectureComponentLayerLogicDataaccessCheck", name = "Devon Component Layer Dataaccess Check", description = "Verify that a business component may not depend on the dataaccess-layer of another component.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureComponentLayerLogicDataaccessCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Component sourceComponent, Devon4jPackage target,
      String targetTypeSimpleName) {

    if (source.isLayerLogic() && target.isLayerDataAccess()) {
      return "Logic layer ('" + source.toString()
          + "') shall not call code from dataaccess layer in different component ('" + target.toString() + "').";
    }
    return null;
  }

}
