package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentCheck;

/**
 * {@link DevonArchitectureComponentCheck} verifying that the service layer does not depend on the service layer of
 * another {@link Component}.
 */
@Rule(key = "C3", name = "devonfw Layer Service-Service Component Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "component" })
public class DevonArchitectureLayerService2Service4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (sourcePkg.isLayerService() && targetPkg.isLayerService()) {
      return "Code from service layer shall not depend on service layer of a different component. ('"
          + sourcePkg.getComponentAndLayer() + "' is dependent on '" + targetPkg.getComponentAndLayer() + "')";
    }
    return null;
  }

}
