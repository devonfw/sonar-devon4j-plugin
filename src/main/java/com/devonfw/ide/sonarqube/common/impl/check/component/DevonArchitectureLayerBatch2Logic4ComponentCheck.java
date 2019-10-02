package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentCheck;

/**
 * {@link DevonArchitectureComponentCheck} verifying that the batch layer does not depend on the logic layer of another
 * {@link Component}.
 */
@Rule(key = "Devon4j:C7", name = "Devon Layer Batch-Logic Component Check", //
    description = "Verify that batch layer does not depend on logic layer of another component.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonArchitectureLayerBatch2Logic4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    if (source.isLayerBatch() && target.isLayerLogic()) {
      return "Code from batch layer shall not depend on logic layer of a different component. ('"
          + source.getComponent() + "." + source.getLayer() + "' is dependent on '" + target.getComponent() + "."
          + target.getLayer() + "')";
    }
    return null;
  }

}
