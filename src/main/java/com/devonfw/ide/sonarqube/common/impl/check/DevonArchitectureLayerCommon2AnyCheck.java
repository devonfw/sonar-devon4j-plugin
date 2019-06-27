package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} verifying that common layer does not depend on any other layer.
 */
@Rule(key = "Devon4j:L1", name = "Devon Layer Common-* Check", //
    description = "Verify that common layer does not depend on any other layer.", //
    priority = Priority.BLOCKER, tags = { "architecture-violation" })
public class DevonArchitectureLayerCommon2AnyCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerCommon() && !target.isLayerCommon()) {
      return "Code from common layer ('" + source.toString() + "') shall not depend on any other layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}