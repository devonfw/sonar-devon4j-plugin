package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * @author ssabah
 *
 */

@Rule(key = "DevonArchitectureScopeBaseImplCheck", name = "Devon Scope Base-Impl Check", description = "Verify that the code from Base package does not depend on code from implementation package.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureScopeBaseImplCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isScopeBase() && target.isScopeImpl()) {
      return "API ('" + source.toString() + "') shall not depend on implementation ('" + target.toString() + "').";
    }
    return null;
  }

}
