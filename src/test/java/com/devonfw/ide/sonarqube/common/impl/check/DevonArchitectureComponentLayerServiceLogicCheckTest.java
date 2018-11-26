package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureComponentLayerServiceLogicCheck}.
 */
public class DevonArchitectureComponentLayerServiceLogicCheckTest {

  /**
   * Test of {@link DevonArchitectureComponentLayerServiceLogicCheck}.
   */
  @Test
  public void test() {

    DevonArchitectureComponentLayerServiceLogicCheck check = new DevonArchitectureComponentLayerServiceLogicCheck();
    JavaCheckVerifier.verify("src/test/files/DevonArchitectureComponentLayerServiceLogicCheck.java", check);
  }
}
