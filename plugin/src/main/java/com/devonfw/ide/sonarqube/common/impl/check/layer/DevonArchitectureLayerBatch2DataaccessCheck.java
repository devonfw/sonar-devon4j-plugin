package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} verifying that batch layer does not depend dataaccess layer.
 */
@Rule(key = "L11", name = "devonfw Layer Batch-Dataaccess Check", //
    priority = Priority.MAJOR, tags = { "architecture-violation", "devonfw", "layer" })
public class DevonArchitectureLayerBatch2DataaccessCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (sourcePkg.isLayerBatch() && targetPkg.isLayerDataAccess()) {
      return "Code from batch layer shall not depend on dataaccess layer. ('" + sourcePkg.getComponentAndLayer()
          + "' is dependent on '" + targetPkg.getComponentAndLayer() + "')";
    }
    return null;
  }

}
