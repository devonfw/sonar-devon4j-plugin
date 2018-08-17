package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.ide.sonarqube.common.api.config.Component;
import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */

@Rule(key = "DevonBusinessArchitectureLayerLogicDataaccessCheck", name = "Devon Layer Dataaccess Check", description = "Verify that the code from layer Logic does not depend on code from layer Client.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonBusinessArchitectureLayerLogicDataaccessCheck extends DevonBusinessArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, Component sourceComponent, OaspPackage target,
      String targetTypeSimpleName) {

    if (source.isLayerLogic() && target.isLayerDataAccess()) {
      return "Logic layer ('" + source.toString()
          + "') shall not call code from dataaccess layer in different component ('" + target.toString() + "').";
    }
    return null;
  }

}
