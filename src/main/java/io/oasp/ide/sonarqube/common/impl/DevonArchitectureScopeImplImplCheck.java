package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 *
 */
@Rule(key = "DevonArchitectureScopeApiImplCheck", name = "Devon Scope API-Impl Check", description = "Verify that the code from API package does not depend on code from implementation package.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureScopeImplImplCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isScopeImpl() && target.isScopeImpl() && !isSameComponentPart(source, target)) {
      return "Implementation ('" + source.toString()
          + "') shall not depend on implementation from other component or layer ('" + target.toString() + "').";
    }
    return null;
  }

  private boolean isSameComponentPart(OaspPackage source, OaspPackage target) {

    return source.getComponent().equals(target.getComponent()) && source.getLayer().equals(target.getLayer());
  }

}
