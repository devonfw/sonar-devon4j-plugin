package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} verifying that batch layer does not depend dataaccess layer.
 */
@Rule(key = "L11")
public class DevonArchitectureLayerBatch2DataaccessCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerBatch() && target.isLayerDataAccess()) {
      return "Code from batch layer shall not depend on dataaccess layer. ('" + source.getComponent() + "."
          + source.getLayer() + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "')";
    }
    return null;
  }

}
