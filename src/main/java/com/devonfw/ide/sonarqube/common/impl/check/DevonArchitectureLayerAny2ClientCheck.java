package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying that only client layer code may depend on client layer.
 */
@Rule(key = "Devon4j:L2", name = "Devon Layer *-Client Check", //
    description = "Verify that only client layer may depend on client layer.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureLayerAny2ClientCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (!source.isLayerClient() && target.isLayerClient()) {
      return "Code from any layer other than client ('" + source.toString() + "') shall not depend on client layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}