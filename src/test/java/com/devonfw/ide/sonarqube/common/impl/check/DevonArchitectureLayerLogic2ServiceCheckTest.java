package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerLogic2ServiceCheck}.
 */
public class DevonArchitectureLayerLogic2ServiceCheckTest {

  /**
   * Test the {@link DevonArchitectureLayerLogic2ServiceCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerLogic2ServiceCheck.java",
        new DevonArchitectureLayerLogic2ServiceCheck());
  }

}
