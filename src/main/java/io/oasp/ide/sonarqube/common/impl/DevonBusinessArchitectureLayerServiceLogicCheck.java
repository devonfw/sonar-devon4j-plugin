package io.oasp.ide.sonarqube.common.impl;

import io.oasp.ide.sonarqube.common.api.config.Component;
import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */
public class DevonBusinessArchitectureLayerServiceLogicCheck extends DevonBusinessArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, Component sourceComponent, OaspPackage target,
      String targetTypeSimpleName) {

    if (source.isLayerService() && target.isLayerLogic()) {
      return "Service layer ('" + source.toString()
          + "') shall not call code from logic layer in different component ('" + target.toString() + "').";
    }
    return null;
  }

}
