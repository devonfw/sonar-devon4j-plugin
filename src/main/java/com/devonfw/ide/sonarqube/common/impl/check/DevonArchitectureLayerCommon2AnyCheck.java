package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying that common layer does not depend on any other layer.
 */
@Rule(key = "Devon4j:L1", name = "Devon Layer Common-* Check", //
    description = "Verify that common layer does not depend on any other layer.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureLayerCommon2AnyCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerCommon() && !target.isLayerCommon()) {
      return "Code from common layer ('" + source.toString() + "') shall not depend on any other layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}