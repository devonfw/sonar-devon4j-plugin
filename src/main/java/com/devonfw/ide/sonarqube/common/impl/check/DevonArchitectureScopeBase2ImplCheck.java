package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} to verify that code from base scope does not depend on impl scope.
 */
@Rule(key = "Devon4j:S3", name = "Devon Scope Base-Impl Check", //
    description = "Verify that base scope does not depend impl scope.", //
    priority = Priority.MAJOR, tags = { "bug" })
public class DevonArchitectureScopeBase2ImplCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isScopeBase() && target.isScopeImpl() && isSameComponentPart(source, target)) {
      return "Code from base scope ('" + source.toString() + "') shall not depend on impl scope ('" + target.toString()
          + "').";
    }
    return null;
  }

}
