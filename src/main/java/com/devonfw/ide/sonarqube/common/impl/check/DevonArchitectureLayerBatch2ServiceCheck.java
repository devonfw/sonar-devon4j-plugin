package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} verifying that batch layer does not depend service layer.
 */
@Rule(key = "Devon4j:L7", name = "Devon Layer Batch-Service Check", //
    description = "Verify that batch layer does not depend on service layer.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureLayerBatch2ServiceCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerBatch() && target.isLayerService()) {
      return "Code from batch layer ('" + source.toString() + "') shall not depend on service layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}
