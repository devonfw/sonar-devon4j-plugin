package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying that service layer does not depend batch layer.
 */
@Rule(key = "Devon4j:L6", name = "Devon Layer Service-Batch Check", //
    description = "Verify that service layer does not depend batch layer.", //
    priority = Priority.MAJOR, tags = { "bug" })
public class DevonArchitectureLayerService2BatchCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerService() && target.isLayerBatch()) {
      return "Code from service layer ('" + source.toString() + "') shall not depend on batch layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}
