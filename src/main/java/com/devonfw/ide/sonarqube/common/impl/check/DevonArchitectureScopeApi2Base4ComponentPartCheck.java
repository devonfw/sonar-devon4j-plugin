package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} to verify that code from base scope does not depend on base scope from other component
 * part.
 */
@Rule(key = "Devon4j:S4", name = "Devon Scope Api-Base Component-Part Check", //
    description = "Verify that api scope does not depend on base scope from another component part.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonArchitectureScopeApi2Base4ComponentPartCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeApi() && target.isScopeBase() && !isSameComponentPart(source, target)) {
      return "Code from api scope ('" + source.toString()
          + "') shall not depend on base scope of other component part ('" + target.toString() + "').";
    }
    return null;
  }

}
