package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerClient2BatchCheck}.
 */
public class DevonArchitectureLayerClient2BatchCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerClient2BatchCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/layer/DevonArchitectureLayerClient2BatchCheck.java",
        new DevonArchitectureLayerClient2BatchCheck());
  }

}
