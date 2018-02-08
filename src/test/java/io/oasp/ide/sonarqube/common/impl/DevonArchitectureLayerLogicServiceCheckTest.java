package io.oasp.ide.sonarqube.common.impl;

/**
 * @author ssabah
 *
 */

/**
 * Test of {@link DevonArchitectureLayerServiceLogicCheck}.
 */

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class DevonArchitectureLayerLogicServiceCheckTest {

  /**
   * Test the {@link DevonArchitectureLayerLogicServiceCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerLogicServiceCheck.java",
        new DevonArchitectureLayerLogicServiceCheck());
  }

}
