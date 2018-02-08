package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */
@Rule(key = "DevonArchitectureLayerDataaccessServiceCheck", name = "Devon Layer Dataaccess-Service Check", description = "Verify that the code from layer Service does not depend on code from layer Dataaccess.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerDataaccessServiceCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isLayerDataAccess() && target.isLayerService()) {
      return "Layer Data-Access ('" + source.toString() + "') shall not call from Layer Service ('" + target.toString()
          + "').";
    }
    return null;
  }

}