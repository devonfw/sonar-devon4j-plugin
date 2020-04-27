package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from api scope does not depend on base scope.
 */
@Rule(key = "S2", name = "devonfw Scope Api-Base Check", //
    priority = Priority.MAJOR, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeApi2BaseCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeApi() && target.isScopeBase() && isSameComponentPart(source, target)) {
      return "Code from api scope shall not depend on base scope. ('" + source.getComponent() + "." + source.getLayer()
          + "." + source.getScope() + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "."
          + target.getScope() + "')";
    }
    return null;
  }

}
