package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} verifying that dataaccess layer does not depend on logic layer.
 */
@Rule(key = "L12")
public class DevonArchitectureLayerDataaccess2LogicCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerDataAccess() && target.isLayerLogic()) {
      return "Dataaccess layer shall not depend on logic layer. ('" + source.getComponent() + "." + source.getLayer()
          + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "')";
    }
    return null;
  }
}
