package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentCheck;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a dataaccess layer does not depend on the dataaccess layer of
 * another {@link Component}.
 */
@Rule(key = "C6", name = "Devon Layer Dataaccess-Dataaccess Component Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "component" })
public class DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    if (source.isLayerDataAccess() && target.isLayerDataAccess()
        && !isSameOrGeneralComponentWithSameOrCommonLayer(source, target)) {
      return "Code from dataaccess layer shall not depend on dataaccess layer of a different component. ('"
          + source.getComponent() + "." + source.getLayer() + "' is dependent on '" + target.getComponent() + "."
          + target.getLayer() + "')";
    }
    return null;
  }

}
