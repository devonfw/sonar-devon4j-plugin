package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from impl scope does not depend on base scope from other component
 * part.
 */
@Rule(key = "S6", name = "devonfw Scope Impl-Base Component-Part Check", //
    priority = Priority.MAJOR, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeImpl2Base4ComponentPartCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (sourcePkg.isScopeImpl() && targetPkg.isScopeBase()
        && !isSameOrGeneralComponentWithSameOrCommonLayer(sourcePkg, targetPkg)) {
      return "Code from impl scope shall not depend on base scope of other component part. ('"
          + sourcePkg.getComponentAndLayerAndScope() + "' is dependent on '" + targetPkg.getComponentAndLayerAndScope()
          + "')";
    }
    return null;
  }

}
