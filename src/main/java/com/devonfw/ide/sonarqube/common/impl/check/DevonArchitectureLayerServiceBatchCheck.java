package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * @author ssabah
 *
 */

@Rule(key = "DevonArchitectureLayerServiceBatchCheck", name = "Devon Layer Batch Check", description = "Verify that the code from layer Service does not depend on code from layer Batch.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerServiceBatchCheck extends DevonArchitectureCheck {

  @Override

  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerService() && target.isLayerBatch()) {
      return "Layer Service ('" + source.toString() + "') shall not call from Layer Batch ('" + target.toString()
          + "').";
    }
    return null;
  }

}
