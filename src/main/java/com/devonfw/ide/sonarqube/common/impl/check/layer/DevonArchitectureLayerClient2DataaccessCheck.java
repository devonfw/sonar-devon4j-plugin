package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} verifying that client layer does not depend on dataaccess layer.
 */
@Rule(key = "L4", name = "devonfw Layer Client-Dataaccess Check", //
    priority = Priority.BLOCKER, tags = { "architecture-violation", "devonfw", "layer" })
public class DevonArchitectureLayerClient2DataaccessCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerClient() && target.isLayerDataAccess()) {
      return "Code from client layer shall not depend on dataaccess layer. ('" + source.getComponent() + "."
          + source.getLayer() + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "')";
    }
    return null;
  }

}
