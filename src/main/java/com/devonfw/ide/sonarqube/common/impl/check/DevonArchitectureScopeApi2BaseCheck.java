package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} to verify that code from api scope does not depend on base scope.
 */
@Rule(key = "Devon4j:S2", name = "Devon Scope Api-Base Check", //
    description = "Verify that api scope does not depend on base scope.", //
    priority = Priority.MAJOR, tags = { "bug" })
public class DevonArchitectureScopeApi2BaseCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isScopeApi() && target.isScopeBase() && isSameComponentPart(source, target)) {
      return "Code from api scope ('" + source.toString() + "') shall not depend on base scope ('" + target.toString()
          + "').";
    }
    return null;
  }

}
