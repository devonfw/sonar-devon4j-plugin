package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerLogic2Dataaccess4ComponentCheck}.
 */
public class DevonArchitectureLayerLogic2Dataaccess4ComponentCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerLogic2Dataaccess4ComponentCheck}.
   */
  @Test
  public void testNotOK() {

    JavaCheckVerifier.verify(
        "src/test/files/component/DevonArchitectureLayerLogic2Dataaccess4ComponentCheck_NotOK.java",
        new DevonArchitectureLayerLogic2Dataaccess4ComponentCheck());
  }

  /**
   * Test of {@link DevonArchitectureLayerLogic2Dataaccess4ComponentCheck}.
   */
  @Test
  public void testOKSameComponent() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/component/DevonArchitectureLayerLogic2Dataaccess4ComponentCheck_OKSameComponent.java",
        new DevonArchitectureLayerLogic2Dataaccess4ComponentCheck());
  }

  /**
   * Test of {@link DevonArchitectureLayerLogic2Dataaccess4ComponentCheck}.
   */
  @Test
  public void testOKRevisionMetadata() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/component/DevonArchitectureLayerLogic2Dataaccess4ComponentCheck_OKRevisionMetadata.java",
        new DevonArchitectureLayerLogic2Dataaccess4ComponentCheck());
  }

}
