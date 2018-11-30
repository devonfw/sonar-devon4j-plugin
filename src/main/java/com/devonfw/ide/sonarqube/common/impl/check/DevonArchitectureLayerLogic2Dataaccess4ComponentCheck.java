package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a logic layer does not depend on the dataaccess layer of
 * another {@link Component}.
 */
@Rule(key = "Devon4j:C5", name = "Devon Layer Logic-Dataaccess Component Check", //
    description = "Verify that logic layer may not depend on the dataaccess layer of another component.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureLayerLogic2Dataaccess4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Component sourceComponent, Devon4jPackage target,
      String targetTypeSimpleName) {

    if (source.isLayerLogic() && target.isLayerDataAccess()) {
      return "Code from logic layer ('" + source.toString()
          + "') shall not depend on dataaccess layer of a different component ('" + target.toString() + "').";
    }
    return null;
  }

}
