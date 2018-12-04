package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} verifying that client layer does not depend on batch layer.
 */
@Rule(key = "Devon4j:L5", name = "Devon Layer Client-Logic Check", //
    description = "Verify that client layer does not depend on batch layer.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureLayerClient2BatchCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerClient() && target.isLayerBatch()) {
      return "Code from client layer ('" + source.toString() + "') shall not depend on batch layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}
