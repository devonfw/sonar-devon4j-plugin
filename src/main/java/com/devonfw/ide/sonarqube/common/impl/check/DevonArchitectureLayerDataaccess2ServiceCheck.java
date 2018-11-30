package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying that dataaccess layer does not depend on service layer.
 */
@Rule(key = "Devon4j:L10", name = "Devon Layer Dataaccess-Service Check", //
    description = "Verify that dataaccess layer does not depend service layer.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureLayerDataaccess2ServiceCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerDataAccess() && target.isLayerService()) {
      return "Code from dataaccess layer ('" + source.toString() + "') shall not depend on service layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}