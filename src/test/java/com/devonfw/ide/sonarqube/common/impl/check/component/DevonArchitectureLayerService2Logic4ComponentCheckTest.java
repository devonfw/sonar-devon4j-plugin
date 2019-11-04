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
  public void test() {

    JavaCheckVerifier.verify("src/test/files/component/DevonArchitectureComponentLayerServiceLogicCheck.java",
        new DevonArchitectureLayerService2Logic4ComponentCheck());
  }
}
