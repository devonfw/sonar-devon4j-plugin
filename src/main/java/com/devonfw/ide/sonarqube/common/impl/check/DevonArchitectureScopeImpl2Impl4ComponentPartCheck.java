package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} to verify that code from impl scope does not depend on impl scope of other component
 * part.
 */
@Rule(key = "Devon4j:S8", name = "Devon Scope Impl-Impl Component-Part Check", //
    description = "Verify that impl scope does not depend on impl scope from another component part.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureScopeImpl2Impl4ComponentPartCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeImpl() && target.isScopeImpl() && !isSameComponentPart(source, target)) {
      return "Code from impl scope ('" + source.toString()
          + "') shall not depend on impl scope of other component part ('" + target.toString() + "').";
    }
    return null;
  }

}
