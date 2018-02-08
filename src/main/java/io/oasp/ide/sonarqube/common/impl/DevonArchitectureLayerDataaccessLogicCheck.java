package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */

@Rule(key = "DevonArchitectureLayerDataaccessLogicCheck", name = "Devon Layer Dataaccess-Logic Check", description = "Verify that the code from layer Dataaccess does not depend on code from layer Logic .", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerDataaccessLogicCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isLayerDataAccess() && target.isLayerLogic()) {
      return "Layer Logic ('" + source.toString() + "') shall not call from Layer Service ('" + target.toString()
          + "').";
    }
    return null;
  }
}
