package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from base scope does not depend on base scope from other component
 * part.
 */
@Rule(key = "S4", name = "devonfw Scope Api-Base Component-Part Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeApi2Base4ComponentPartCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeApi() && target.isScopeBase() && !isSameComponentPart(source, target)) {
      return "Code from api scope shall not depend on base scope of another component part. ('" + source.getComponent()
          + "." + source.getLayer() + "." + source.getScope() + "' is dependent on '" + target.getComponent() + "."
          + target.getLayer() + "." + target.getScope() + "')";
    }
    return null;
  }

}
