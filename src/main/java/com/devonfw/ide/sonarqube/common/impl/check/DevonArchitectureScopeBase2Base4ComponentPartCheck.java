package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} to verify that code from base scope does not depend on base scope from other component
 * part.
 */
@Rule(key = "Devon4j:S7", name = "Devon Scope Base-Base Component-Part Check", //
    description = "Verify that base scope does not depend on base scope from another component part.", //
    priority = Priority.MAJOR, tags = { "bug" })
public class DevonArchitectureScopeBase2Base4ComponentPartCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isScopeBase() && target.isScopeBase() && !isSameComponentPart(source, target)
        && !isSameOrGeneralComponentWithSameOrCommonLayer(source, target)) {
      return "Code from base scope ('" + source.toString()
          + "') shall not depend on base scope of other component part ('" + target.toString() + "').";
    }
    return null;
  }

}
