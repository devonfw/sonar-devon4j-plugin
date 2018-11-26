package com.devonfw.ide.sonarqube.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentDependencyCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentLayerLogicDataaccessCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentLayerServiceLogicCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerBatchDataaccessCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerClientDataaccessCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerDataaccessLogicCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerDataaccessServiceCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerLogicServiceCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerServiceBatchCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerServiceClientCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerServiceDataaccessCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecturePackageCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeApiBaseCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeApiImplCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeBaseBaseCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeBaseImplCheck;

/**
 * {@link CheckRegistrar} for this plugin.
 */
@SonarLintSide
public class DevonSonarRegistrar implements CheckRegistrar {

  @Override
  public void register(RegistrarContext registrarContext) {

    registrarContext.registerClassesForRepository(DevonSonarDefinition.REPOSITORY_KEY, checkClasses(),
        testCheckClasses());
  }

  static List<Class<? extends JavaCheck>> checkClasses() {

    List<Class<? extends JavaCheck>> checks = new ArrayList<>();
    checks.add(DevonArchitecturePackageCheck.class);
    checks.add(DevonArchitectureScopeApiImplCheck.class);
    checks.add(DevonArchitectureLayerDataaccessServiceCheck.class);
    checks.add(DevonArchitectureScopeApiBaseCheck.class);
    checks.add(DevonArchitectureLayerLogicServiceCheck.class);
    checks.add(DevonArchitectureLayerDataaccessLogicCheck.class);
    checks.add(DevonArchitectureLayerServiceDataaccessCheck.class);
    checks.add(DevonArchitectureScopeBaseImplCheck.class);
    checks.add(DevonArchitectureScopeBaseBaseCheck.class);
    checks.add(DevonArchitectureLayerServiceBatchCheck.class);
    checks.add(DevonArchitectureLayerServiceClientCheck.class);
    checks.add(DevonArchitectureLayerBatchDataaccessCheck.class);
    checks.add(DevonArchitectureLayerClientDataaccessCheck.class);
    checks.add(DevonArchitectureComponentDependencyCheck.class);
    checks.add(DevonArchitectureComponentLayerLogicDataaccessCheck.class);
    checks.add(DevonArchitectureComponentLayerServiceLogicCheck.class);
    return checks;
  }

  private static List<Class<? extends JavaCheck>> testCheckClasses() {

    return new ArrayList<>();
  }
}
