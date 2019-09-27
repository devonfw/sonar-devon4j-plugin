package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;

/**
 * {@link DevonArchitectureComponentCheck} verifying that the service layer does not depend on the service layer of
 * another {@link Component}.
 */
@Rule(key = "Devon4j:C3", name = "Devon Layer Service-Service Component Check", //
    description = "Verify that service layer does not depend service layer of another component.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonArchitectureLayerService2Service4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    if (source.isLayerService() && target.isLayerService()) {
      return "Code from service layer shall not depend on service layer of a different component. ('"
          + source.getComponent() + "." + source.getLayer() + "' is dependent on '" + target.getComponent() + "."
          + target.getLayer() + "')";
    }
    return null;
  }

}
