package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} verifying that dataaccess layer does not depend on logic layer.
 */
@Rule(key = "Devon4j:L12", name = "Devon Layer Dataaccess-Logic Check", description = "Verify that dataaccess layer does not depend logic layer.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureLayerDataaccess2LogicCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerDataAccess() && target.isLayerLogic()) {
      return "Dataaccess layer ('" + source.toString() + "') shall not depend on logic layer ('" + target.toString()
          + "').";
    }
    return null;
  }
}
