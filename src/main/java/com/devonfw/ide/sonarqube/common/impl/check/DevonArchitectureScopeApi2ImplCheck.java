package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} to verify that code from api scope does not depend on impl scope.
 */
@Rule(key = "Devon4j:S1", name = "Devon Scope Api-Impl Check", //
    description = "Verify that api scope does not depend on impl scope.", //
    priority = Priority.BLOCKER, tags = { "architecture-violation" })
public class DevonArchitectureScopeApi2ImplCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeApi() && target.isScopeImpl()) {
      return "Code from api scope ('" + source.toString() + "') shall not depend on impl scope ('" + target.toString()
          + "').";
    }
    return null;
  }

}
