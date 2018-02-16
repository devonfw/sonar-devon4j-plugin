package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */

@Rule(key = "DevonArchitectureLayerServiceBatchCheck", name = "Devon Layer Batch Check", description = "Verify that the code from layer Service does not depend on code from layer Batch.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerServiceBatchCheck extends DevonArchitectureCheck {

  @Override

  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isLayerService() && target.isLayerBatch()) {
      return "Layer Service ('" + source.toString() + "') shall not call from Layer Batch ('" + target.toString()
          + "').";
    }
    return null;
  }

}
