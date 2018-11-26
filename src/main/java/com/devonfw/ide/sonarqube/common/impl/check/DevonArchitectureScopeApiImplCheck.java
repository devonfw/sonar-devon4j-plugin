package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 *
 */
@Rule(key = "DevonArchitectureScopeApiImplCheck", name = "Devon Scope API-Impl Check", description = "Verify that the code from API package does not depend on code from implementation package.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureScopeApiImplCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isScopeApi() && target.isScopeImpl()) {
      return "API ('" + source.toString() + "') shall not depend on implementation ('" + target.toString() + "').";
    }
    return null;
  }

}
