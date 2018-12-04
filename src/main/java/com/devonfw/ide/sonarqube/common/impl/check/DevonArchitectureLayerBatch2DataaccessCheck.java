package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} verifying that batch layer does not depend dataaccess layer.
 */
@Rule(key = "Devon4j:L11", name = "Devon Layer Batch-Dataaccess Check", //
    description = "Verify that batch layer does not depend on dataaccess layer.", //
    priority = Priority.MAJOR, tags = { "bug" })
public class DevonArchitectureLayerBatch2DataaccessCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerBatch() && target.isLayerDataAccess()) {
      return "Code from batch layer ('" + source.toString() + "') shall not depend on dataaccess layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}
