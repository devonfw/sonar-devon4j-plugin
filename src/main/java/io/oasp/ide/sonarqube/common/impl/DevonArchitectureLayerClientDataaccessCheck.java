package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */
@Rule(key = "DevonArchitectureLayerClientDataaccessCheck", name = "Devon Layer Client-Dataaccess Check", description = "Verify that the code from layer Client does not depend on code from layer Dataaccess .", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerClientDataaccessCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isLayerClient() && target.isLayerDataAccess()) {
      return "Layer Client ('" + source.toString() + "') shall not call from Layer Service ('" + target.toString()
          + "').";
    }
    return null;
  }

}
