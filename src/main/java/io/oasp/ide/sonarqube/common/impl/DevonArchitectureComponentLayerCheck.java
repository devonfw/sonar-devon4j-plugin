package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */
@Rule(key = "DevonArchitectureComponentLayerCheck", name = "Devon Component Layer Check", description = "Verify that the code from component A does not depend on code from component B in a different layer.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureComponentLayerCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (!source.getComponent().equals(target.getComponent()) && !source.getLayer().equals(target.getLayer())
        && !target.getLayer().contains("common")) {
      return "Code from component '" + source.getComponent() + "' and layer '" + source.getLayer()
          + "' may call code from other components (" + target.getComponent() + ") but not on different layer ("
          + target.getLayer() + ").";
    }

    return null;
  }

}