package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * @author ssabah
 *
 */
@Rule(key = "DevonArchitectureLayerDataaccessServiceCheck", name = "Devon Layer Dataaccess-Service Check", description = "Verify that the code from layer Service does not depend on code from layer Dataaccess.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerDataaccessServiceCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerDataAccess() && target.isLayerService()) {
      return "Layer Data-Access ('" + source.toString() + "') shall not call from Layer Service ('" + target.toString()
          + "').";
    }
    return null;
  }

}