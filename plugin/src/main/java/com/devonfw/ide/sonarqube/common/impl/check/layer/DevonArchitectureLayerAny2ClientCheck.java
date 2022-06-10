package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} verifying that only client layer code may depend on client layer.
 */
@Rule(key = "L2", name = "devonfw Layer *-Client Check", //
    priority = Priority.BLOCKER, tags = { "architecture-violation", "devonfw", "layer" })
public class DevonArchitectureLayerAny2ClientCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (!sourcePkg.isLayerClient() && targetPkg.isLayerClient()) {
      return "Code from any layer other than client shall not depend on client layer. ('"
          + sourcePkg.getComponentAndLayer() + "' is dependent on '" + targetPkg.getComponentAndLayer() + "')";
    }
    return null;
  }

}