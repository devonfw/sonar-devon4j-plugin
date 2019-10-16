package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from base scope does not depend on impl scope.
 */
@Rule(key = "Devon4j:S3", name = "Devon Scope Base-Impl Check", //
    description = "Verify that base scope does not depend impl scope.", //
    priority = Priority.MAJOR, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeBase2ImplCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeBase() && target.isScopeImpl() && isSameComponentPart(source, target)) {
      return "Code from base scope shall not depend on impl scope. ('" + source.getComponent() + "." + source.getLayer()
          + "." + source.getScope() + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "."
          + target.getScope() + "')";
    }
    return null;
  }

}
