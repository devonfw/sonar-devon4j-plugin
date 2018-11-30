package com.devonfw.ide.sonarqube.common.impl.check;

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
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerService2Service4ComponentCheck.java",
        new DevonArchitectureLayerService2Service4ComponentCheck());
  }
}
