package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from api scope does not depend on impl scope.
 */
@Rule(key = "Devon4j:S1", name = "Devon Scope Api-Impl Check", //
    description = "Verify that api scope does not depend on impl scope.", //
    priority = Priority.BLOCKER, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeApi2ImplCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeApi() && target.isScopeImpl()) {
      return "Code from api scope shall not depend on impl scope. ('" + source.getComponent() + "." + source.getLayer()
          + "." + source.getScope() + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "."
          + target.getScope() + "')";
    }
    return null;
  }

}
