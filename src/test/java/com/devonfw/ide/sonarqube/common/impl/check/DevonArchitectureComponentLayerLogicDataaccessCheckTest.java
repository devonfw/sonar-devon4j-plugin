package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureComponentLayerLogicDataaccessCheck}.
 */
public class DevonArchitectureComponentLayerLogicDataaccessCheckTest {

  /**
   * Test of {@link DevonArchitectureComponentLayerLogicDataaccessCheck}.
   */
  @Test
  public void test() {

    DevonArchitectureComponentLayerLogicDataaccessCheck check = new DevonArchitectureComponentLayerLogicDataaccessCheck();
    JavaCheckVerifier.verify("src/test/files/DevonArchitectureComponentLayerLogicDataaccessCheck.java", check);
  }

}
