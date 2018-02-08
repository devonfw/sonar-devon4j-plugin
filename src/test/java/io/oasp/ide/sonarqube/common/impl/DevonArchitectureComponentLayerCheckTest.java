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

public class DevonArchitectureComponentLayerCheckTest {

  /**
   * Test the {@link DevonArchitectureComponentLayerCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureComponentLayerCheck.java",
        new DevonArchitectureComponentLayerCheck());
  }

}
