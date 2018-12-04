package com.devonfw.ide.sonarqube.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyJpaCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyMysemaCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyTransactionalCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentDeclarationCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentDependencyCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerAny2ClientCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerBatch2DataaccessCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerBatch2Logic4ComponentCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerBatch2ServiceCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerClient2BatchCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerClient2DataaccessCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerClient2LogicCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerCommon2AnyCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerDataaccess2LogicCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerDataaccess2ServiceCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerLogic2Dataaccess4ComponentCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerLogic2ServiceCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerService2BatchCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerService2DataaccessCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerService2Logic4ComponentCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerService2Service4ComponentCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecturePackageCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeApi2Base4ComponentPartCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeApi2BaseCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeApi2ImplCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeBase2Base4ComponentPartCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeBase2Impl4ComponentPartCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeBase2ImplCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeImpl2Base4ComponentPartCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeImpl2Impl4ComponentPartCheck;

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
    checks.add(DevonArchitecturePackageCheck.class); // P1

    checks.add(DevonArchitectureLayerCommon2AnyCheck.class); // L1
    checks.add(DevonArchitectureLayerAny2ClientCheck.class); // L2
    checks.add(DevonArchitectureLayerClient2LogicCheck.class); // L3
    checks.add(DevonArchitectureLayerClient2DataaccessCheck.class); // L4
    checks.add(DevonArchitectureLayerClient2BatchCheck.class); // L5
    checks.add(DevonArchitectureLayerService2BatchCheck.class); // L6
    checks.add(DevonArchitectureLayerBatch2ServiceCheck.class); // L7
    checks.add(DevonArchitectureLayerService2DataaccessCheck.class); // L8
    checks.add(DevonArchitectureLayerLogic2ServiceCheck.class); // L9
    checks.add(DevonArchitectureLayerDataaccess2ServiceCheck.class); // L10
    checks.add(DevonArchitectureLayerBatch2DataaccessCheck.class); // L11
    checks.add(DevonArchitectureLayerDataaccess2LogicCheck.class); // L12

    checks.add(DevonArchitectureComponentDeclarationCheck.class); // C1
    checks.add(DevonArchitectureComponentDependencyCheck.class); // C2
    checks.add(DevonArchitectureLayerService2Service4ComponentCheck.class); // C3
    checks.add(DevonArchitectureLayerService2Logic4ComponentCheck.class); // C4
    checks.add(DevonArchitectureLayerLogic2Dataaccess4ComponentCheck.class); // C5
    checks.add(DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck.class); // C6
    checks.add(DevonArchitectureLayerBatch2Logic4ComponentCheck.class); // C7

    checks.add(DevonArchitectureScopeApi2ImplCheck.class); // S1
    checks.add(DevonArchitectureScopeApi2BaseCheck.class); // S2
    checks.add(DevonArchitectureScopeBase2ImplCheck.class); // S3
    checks.add(DevonArchitectureScopeApi2Base4ComponentPartCheck.class); // S4
    checks.add(DevonArchitectureScopeBase2Impl4ComponentPartCheck.class); // S5
    checks.add(DevonArchitectureScopeImpl2Base4ComponentPartCheck.class); // S6
    checks.add(DevonArchitectureScopeBase2Base4ComponentPartCheck.class); // S7
    checks.add(DevonArchitectureScopeImpl2Impl4ComponentPartCheck.class); // S8

    checks.add(DevonArchitecture3rdPartyTransactionalCheck.class); // E1
    checks.add(DevonArchitecture3rdPartyMysemaCheck.class); // E2
    checks.add(DevonArchitecture3rdPartyJpaCheck.class); // E3
    return checks;
  }

  private static List<Class<? extends JavaCheck>> testCheckClasses() {

    return new ArrayList<>();
  }
}
