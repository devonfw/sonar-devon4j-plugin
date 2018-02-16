package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */

@Rule(key = "DevonArchitectureLayerBatchDataaccessCheck", name = "Devon Layer Batch-Dataaccess Check", description = "Verify that the code from layer Batch does not depend on code from layer Dataaccess .", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerBatchDataaccessCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isLayerBatch() && target.isLayerDataAccess()) {
      return "Layer Batch ('" + source.toString() + "') shall not call from Layer Service ('" + target.toString()
          + "').";
    }
    return null;
  }

}
