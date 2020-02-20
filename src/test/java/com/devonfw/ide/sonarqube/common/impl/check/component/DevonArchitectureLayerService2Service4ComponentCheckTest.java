package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerService2Service4ComponentCheck}.
 */
public class DevonArchitectureLayerService2Service4ComponentCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerService2Service4ComponentCheck}.
   */
  @Test
  public void testNotOK() {

    JavaCheckVerifier.verify("src/test/files/component/DevonArchitectureLayerService2Service4ComponentCheck_NotOK.java",
        new DevonArchitectureLayerService2Service4ComponentCheck());
  }

  // /**
  // * Test of {@link DevonArchitectureLayerService2Service4ComponentCheck}.
  // */
  // @Test
  // public void testOK() {
  //
  // JavaCheckVerifier.verifyNoIssue(
  // "src/test/files/component/DevonArchitectureLayerService2Service4ComponentCheck_OK.java",
  // new DevonArchitectureLayerService2Service4ComponentCheck());
  // }

}
