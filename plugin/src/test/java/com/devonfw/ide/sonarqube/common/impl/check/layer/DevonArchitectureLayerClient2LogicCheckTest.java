package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerClient2LogicCheck}.
 */
public class DevonArchitectureLayerClient2LogicCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerClient2LogicCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/layer/DevonArchitectureLayerClient2LogicCheck.java",
        new DevonArchitectureLayerClient2LogicCheck());
  }

}
