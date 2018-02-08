package io.oasp.ide.sonarqube.common.impl;

/**
 * @author ssabah
 *
 */

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerDataaccessLogicCheck}.
 */

public class DevonArchitectureLayerDataaccessServiceCheckTest {

  /**
   * Test the {@link DevonArchitectureLayerDataaccessServiceCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerDataaccessServiceCheck.java",
        new DevonArchitectureLayerDataaccessServiceCheck());
  }

}
