package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} to verify that code from base scope does not depend on impl scope from other component
 * part.
 */
@Rule(key = "Devon4j:S5", name = "Devon Scope Base-Impl Component-Part Check", //
    description = "Verify that base scope does not depend on impl scope from another component part.", //
    priority = Priority.BLOCKER, tags = { "architecture-violation" })
public class DevonArchitectureScopeBase2Impl4ComponentPartCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeBase() && target.isScopeImpl() && !isSameComponentPart(source, target)) {
      return "Code from base scope ('" + source.toString()
          + "') shall not depend on impl scope of other component part ('" + target.toString() + "').";
    }
    return null;
  }

}
