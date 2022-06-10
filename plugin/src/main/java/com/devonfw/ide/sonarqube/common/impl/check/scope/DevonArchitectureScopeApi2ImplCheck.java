package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from api scope does not depend on impl scope.
 */
@Rule(key = "S1", name = "devonfw Scope Api-Impl Check", //
    priority = Priority.BLOCKER, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeApi2ImplCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (sourcePkg.isScopeApi() && targetPkg.isScopeImpl()) {
      return "Code from api scope shall not depend on impl scope. ('" + sourcePkg.getComponentAndLayerAndScope()
          + "' is dependent on '" + targetPkg.getComponentAndLayerAndScope() + "')";
    }
    return null;
  }

}
