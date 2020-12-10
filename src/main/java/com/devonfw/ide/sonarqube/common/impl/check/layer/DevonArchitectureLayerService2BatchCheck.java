package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} verifying that service layer does not depend batch layer.
 */
@Rule(key = "L6", name = "devonfw Layer Service-Batch Check", //
    priority = Priority.MAJOR, tags = { "architecture-violation", "devonfw", "layer" })
public class DevonArchitectureLayerService2BatchCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (sourcePkg.isLayerService() && targetPkg.isLayerBatch()) {
      return "Code from service layer shall not depend on batch layer. ('" + sourcePkg.getComponentAndLayer()
          + "' is dependent on '" + targetPkg.getComponentAndLayer() + "')";
    }
    return null;
  }

}
