package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying that client layer does not depend on logic layer.
 */
@Rule(key = "Devon4j:L3", name = "Devon Layer Client-Logic Check", //
    description = "Verify that client layer does not depend on logic layer.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureLayerClient2LogicCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerClient() && target.isLayerLogic()) {
      return "Code from client layer ('" + source.toString() + "') shall not depend on logic layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}
