package com.devonfw.ide.sonarqube.common.impl.check;

/**
 * @author ssabah
 *
 */

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerDataaccess2LogicCheck}.
 */

public class DevonArchitectureLayerDataaccess2ServiceCheckTest {

  /**
   * Test the {@link DevonArchitectureLayerDataaccess2ServiceCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerDataaccess2ServiceCheck.java",
        new DevonArchitectureLayerDataaccess2ServiceCheck());
  }

}
