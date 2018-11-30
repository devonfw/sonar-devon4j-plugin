package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying that dataaccess layer does not depend on logic layer.
 */
@Rule(key = "Devon4j:L12", name = "Devon Layer Dataaccess-Logic Check", description = "Verify that dataaccess layer does not depend logic layer.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureLayerDataaccess2LogicCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerDataAccess() && target.isLayerLogic()) {
      return "Dataaccess layer ('" + source.toString() + "') shall depend on logic layer ('" + target.toString()
          + "').";
    }
    return null;
  }
}
