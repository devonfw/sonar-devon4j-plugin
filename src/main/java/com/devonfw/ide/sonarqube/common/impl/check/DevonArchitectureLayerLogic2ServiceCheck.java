package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying that code from logic layer does not depend on service layer (of same app).
 */
@Rule(key = "Devon4j:L9", name = "Devon Layer Logic-Service Check", //
    description = "Verify that logic layer does not depend on service layer (of same app).", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitectureLayerLogic2ServiceCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerLogic() && target.isLayerService() && isSameRootApplication(source, target)) {
      return "Code from logic layer ('" + source.toString() + "') shall not depend on service layer ('"
          + target.toString() + "').";
    }
    return null;
  }

}
