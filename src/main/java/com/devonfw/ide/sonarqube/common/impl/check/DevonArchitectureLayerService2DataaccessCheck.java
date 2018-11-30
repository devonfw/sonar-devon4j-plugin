package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying that code from service layer does not depend on dataaccess layer.
 */
@Rule(key = "Devon4j:L8", name = "Devon Layer Service-Dataaccess Check", //
    description = "Verify that service layer does not depend on dataaccess layer.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureLayerService2DataaccessCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerService() && target.isLayerDataAccess()) {
      return "Code from service layer ('" + source.toString() + "') shall not depend on dataacssess layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}