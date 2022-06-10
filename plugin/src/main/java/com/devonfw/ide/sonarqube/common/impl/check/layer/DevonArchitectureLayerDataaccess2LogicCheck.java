package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} verifying that dataaccess layer does not depend on logic layer.
 */
@Rule(key = "L12", name = "devonfw Layer Dataaccess-Logic Check", //
    priority = Priority.BLOCKER, tags = { "architecture-violation", "devonfw", "layer" })
public class DevonArchitectureLayerDataaccess2LogicCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (sourcePkg.isLayerDataAccess() && targetPkg.isLayerLogic()) {
      return "Dataaccess layer shall not depend on logic layer. ('" + sourcePkg.getComponentAndLayer()
          + "' is dependent on '" + targetPkg.getComponentAndLayer() + "')";
    }
    return null;
  }
}
