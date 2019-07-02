package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} verifying that client layer does not depend on dataaccess layer.
 */
@Rule(key = "Devon4j:L4", name = "Devon Layer Client-Dataaccess Check", //
    description = "Verify that client layer does not depend dataaccess layer.", //
    priority = Priority.BLOCKER, tags = { "architecture-violation" })
public class DevonArchitectureLayerClient2DataaccessCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerClient() && target.isLayerDataAccess()) {
      return "Code from client layer ('" + source.toString() + "') shall not depend on dataaccess layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}
