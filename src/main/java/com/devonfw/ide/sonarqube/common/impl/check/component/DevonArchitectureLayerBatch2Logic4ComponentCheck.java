package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentCheck;

/**
 * {@link DevonArchitectureComponentCheck} verifying that the batch layer does not depend on the logic layer of another
 * {@link Component}.
 */
@Rule(key = "C7", name = "devonfw Layer Batch-Logic Component Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "component" })
public class DevonArchitectureLayerBatch2Logic4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (sourcePkg.isLayerBatch() && targetPkg.isLayerLogic()) {
      return "Code from batch layer shall not depend on logic layer of a different component. ('"
          + sourcePkg.getComponentAndLayer() + "' is dependent on '" + targetPkg.getComponentAndLayer() + "')";
    }
    return null;
  }

}
