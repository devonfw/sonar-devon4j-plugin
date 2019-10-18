package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentCheck;

/**
 * {@link DevonArchitectureComponentCheck} verifying that the service layer of a {@link Component} may not depend on the
 * logic layer of another {@link Component}.
 */
@Rule(key = "C4")
public class DevonArchitectureLayerService2Logic4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    if (source.isLayerService() && target.isLayerLogic()) {
      return "Code from service layer of a component shall not depend on logic layer of a different component. ('"
          + source.getComponent() + "." + source.getLayer() + "' is dependent on '" + target.getComponent() + "."
          + target.getLayer() + "')";
    }
    return null;
  }

}
