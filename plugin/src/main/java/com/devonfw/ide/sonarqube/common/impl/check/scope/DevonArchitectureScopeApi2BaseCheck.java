package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from api scope does not depend on base scope.
 */
@Rule(key = "S2", name = "devonfw Scope Api-Base Check", //
    priority = Priority.MAJOR, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeApi2BaseCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (sourcePkg.isScopeApi() && targetPkg.isScopeBase() && sourcePkg.hasSameComponentPart(targetPkg)) {
      return "Code from api scope shall not depend on base scope. ('" + sourcePkg.getComponentAndLayerAndScope()
          + "' is dependent on '" + targetPkg.getComponentAndLayerAndScope() + "')";
    }
    return null;
  }

}
