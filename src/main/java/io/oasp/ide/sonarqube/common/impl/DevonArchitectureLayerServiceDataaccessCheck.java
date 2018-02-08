package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */
@Rule(key = "DevonArchitectureLayerServiceDataaccessCheck", name = "Devon Layer Service-Dataaccess Check", description = "Verify that the code from layer Service does not depend on code from layer Dataaccess.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerServiceDataaccessCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isLayerService() && target.isLayerDataAccess()) {
      return "Layer Service ('" + source.toString() + "') shall not call from Layer Data-Acssess ('" + target.toString()
          + "').";
    }
    return null;
  }

}