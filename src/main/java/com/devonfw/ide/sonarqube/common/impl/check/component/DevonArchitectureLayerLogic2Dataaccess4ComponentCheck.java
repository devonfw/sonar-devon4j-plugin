package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentCheck;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a logic layer does not depend on the dataaccess layer of
 * another {@link Component}.
 */
@Rule(key = "C5", name = "devonfw Layer Logic-Dataaccess Component Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "component" })
public class DevonArchitectureLayerLogic2Dataaccess4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    if (sourcePkg.isLayerLogic() && targetPkg.isLayerDataAccess()) {
      if (target.getQualifiedName().equals("com.devonfw.module.jpa.dataaccess.api.RevisionMetadata")) {
        return null; // specific exclusion for unclean packaging
      }
      return "Code from logic layer shall not depend on dataaccess layer of a different component. ('"
          + sourcePkg.getComponentAndLayer() + "' is dependent on '" + targetPkg.getComponentAndLayer() + "')";
    }
    return null;
  }

}
