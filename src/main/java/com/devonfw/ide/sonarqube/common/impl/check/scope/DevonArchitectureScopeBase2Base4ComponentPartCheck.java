package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from base scope does not depend on base scope from other component
 * part.
 */
@Rule(key = "Devon4j:S7", name = "Devon Scope Base-Base Component-Part Check", //
    description = "Verify that base scope does not depend on base scope from another component part.", //
    priority = Priority.MAJOR, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeBase2Base4ComponentPartCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeBase() && target.isScopeBase() && !isSameComponentPart(source, target)
        && !isSameOrGeneralComponentWithSameOrCommonLayer(source, target)) {
      return "Code from base scope shall not depend on base scope of other component part. ('" + source.getComponent()
          + "." + source.getLayer() + "." + source.getScope() + "' is dependent on '" + target.getComponent() + "."
          + target.getLayer() + "." + target.getScope() + "')";
    }
    return null;
  }

}
