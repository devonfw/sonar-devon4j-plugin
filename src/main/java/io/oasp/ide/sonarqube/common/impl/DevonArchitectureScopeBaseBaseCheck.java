package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */

@Rule(key = "DevonArchitectureScopeBaseBaseCheck", name = "Devon Scope Base-Base Check", description = "Verify that the code from Base package does not depend on code from another Base package.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureScopeBaseBaseCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isScopeBase() && target.isScopeBase() && !isSameComponentPart(source, target)) {
      return "Implementation ('" + source.toString()
          + "') shall not depend on implementation from other component or layer ('" + target.toString() + "').";
    }
    return null;
  }

  private boolean isSameComponentPart(OaspPackage source, OaspPackage target) {

    return source.getComponent().equals(target.getComponent()) && source.getLayer().equals(target.getLayer());
  }

}
