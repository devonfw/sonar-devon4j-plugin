package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerService2Logic4ComponentCheck}.
 */
public class DevonArchitectureLayerService2Logic4ComponentCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerService2Logic4ComponentCheck}.
   */
  @Test
  public void testNotOK() {

    JavaCheckVerifier.verify("src/test/files/component/DevonArchitectureComponentLayerServiceLogicCheck_NotOK.java",
        new DevonArchitectureLayerService2Logic4ComponentCheck());
  }

  /**
   * Test of {@link DevonArchitectureLayerService2Logic4ComponentCheck}.
   */
  @Test
  public void testOKSameComponent() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/component/DevonArchitectureComponentLayerServiceLogicCheck_OKSameComponent.java",
        new DevonArchitectureLayerService2Logic4ComponentCheck());
  }

  /**
   * Test of {@link DevonArchitectureLayerService2Logic4ComponentCheck}.
   */
  @Test
  public void testOKDifferentComponent() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/component/DevonArchitectureComponentLayerServiceLogicCheck_OKDifferentComponent.java",
        new DevonArchitectureLayerService2Logic4ComponentCheck());
  }

}
