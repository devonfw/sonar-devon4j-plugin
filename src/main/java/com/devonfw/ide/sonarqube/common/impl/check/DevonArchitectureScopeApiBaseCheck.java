package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * @author ssabah
 *
 */
@Rule(key = "DevonArchitectureScopeApiBaseCheck", name = "Devon Scope API-Base Check", description = "Verify that the code from API package does not depend on code from BASIC package.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureScopeApiBaseCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isScopeApi() && target.isScopeBase()) {
      return "API ('" + source.toString() + "') shall not depend on implementation ('" + target.toString() + "').";
    }
    return null;
  }

}
