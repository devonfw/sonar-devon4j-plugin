package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} to verify that code from base scope does not depend on impl scope from other component
 * part.
 */
@Rule(key = "Devon4j:S5", name = "Devon Scope Base-Impl Component-Part Check", //
    description = "Verify that base scope does not depend on impl scope from another component part.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureScopeBase2Impl4ComponentPartCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isScopeBase() && target.isScopeImpl() && !isSameComponentPart(source, target)) {
      return "Code from base scope ('" + source.toString()
          + "') shall not depend on impl scope of other component part ('" + target.toString() + "').";
    }
    return null;
  }

}
