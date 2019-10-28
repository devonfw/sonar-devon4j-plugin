package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} verifying that service layer does not depend batch layer.
 */
@Rule(key = "L6", name = "Devon Layer Service-Batch Check", //
    priority = Priority.MAJOR, tags = { "architecture-violation", "devonfw", "layer" })
public class DevonArchitectureLayerService2BatchCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerService() && target.isLayerBatch()) {
      return "Code from service layer shall not depend on batch layer. ('" + source.getComponent() + "."
          + source.getLayer() + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "')";
    }
    return null;
  }

}
