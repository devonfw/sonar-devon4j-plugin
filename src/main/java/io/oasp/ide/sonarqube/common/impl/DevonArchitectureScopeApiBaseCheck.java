package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */
@Rule(key = "DevonArchitectureScopeApiBaseCheck", name = "Devon Scope API-Base Check", description = "Verify that the code from API package does not depend on code from BASIC package.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureScopeApiBaseCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isScopeApi() && target.isScopeBase()) {
      return "API ('" + source.toString() + "') shall not depend on implementation ('" + target.toString() + "').";
    }
    return null;
  }

}
