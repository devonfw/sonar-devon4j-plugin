package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} to verify that code from api scope does not depend on impl scope.
 */
@Rule(key = "Devon4j:S1", name = "Devon Scope Api-Impl Check", //
    description = "Verify that api scope does not depend on impl scope.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureScopeApi2ImplCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isScopeApi() && target.isScopeImpl()) {
      return "Code from api scope ('" + source.toString() + "') shall not depend on impl scope ('" + target.toString()
          + "').";
    }
    return null;
  }

}
