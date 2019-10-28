package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} verifying that code from logic layer does not depend on service layer (of same app).
 */
@Rule(key = "L9", name = "Devon Layer Logic-Service Check", //
    priority = Priority.BLOCKER, tags = { "architecture-violation", "devonfw", "layer" })
public class DevonArchitectureLayerLogic2ServiceCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerLogic() && target.isLayerService() && isSameRootApplication(source, target)) {
      return "Code from logic layer shall not depend on service layer. ('" + source.getComponent() + "."
          + source.getLayer() + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "')";
    }
    return null;
  }

}
