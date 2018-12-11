package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} verifying that code from service layer does not depend on dataaccess layer.
 */
@Rule(key = "Devon4j:L8", name = "Devon Layer Service-Dataaccess Check", //
    description = "Verify that service layer does not depend on dataaccess layer.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureLayerService2DataaccessCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isLayerService() && target.isLayerDataAccess()) {
      if (target.toString().equals("com.devonfw.module.jpa.dataaccess.api.RevisionMetadata")) {
        return null; // specific exclusion for unclean packaging
      }
      return "Code from service layer ('" + source.toString() + "') shall not depend on dataacssess layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}