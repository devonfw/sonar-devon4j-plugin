package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} to verify that code from impl scope does not depend on base scope from other component
 * part.
 */
@Rule(key = "Devon4j:S6", name = "Devon Scope Impl-Base Component-Part Check", //
    description = "Verify that impl scope does not depend on base scope from another component part.", //
    priority = Priority.MAJOR, tags = { "bug" })
public class DevonArchitectureScopeImpl2Base4ComponentPartCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeImpl() && target.isScopeBase() && !isSameOrGeneralComponentWithSameOrCommonLayer(source, target)) {
      return "Code from impl scope ('" + source.toString()
          + "') shall not depend on base scope of other component part ('" + target.toString() + "').";
    }
    return null;
  }

}
