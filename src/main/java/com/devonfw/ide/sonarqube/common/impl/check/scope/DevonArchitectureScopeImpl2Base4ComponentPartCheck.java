package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from impl scope does not depend on base scope from other component
 * part.
 */
@Rule(key = "S6", name = "devonfw Scope Impl-Base Component-Part Check", //
    priority = Priority.MAJOR, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeImpl2Base4ComponentPartCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeImpl() && target.isScopeBase()
        && !isSameOrGeneralComponentWithSameOrCommonLayer(source, target)) {
      return "Code from impl scope shall not depend on base scope of other component part. ('" + source.getComponent()
          + "." + source.getLayer() + "." + source.getScope() + "' is dependent on '" + target.getComponent() + "."
          + target.getLayer() + "." + target.getScope() + "')";
    }
    return null;
  }

}
