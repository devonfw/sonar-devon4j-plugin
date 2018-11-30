package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerDataaccess2LogicCheck}.
 */
public class DevonArchitectureLayerDataaccess2LogicCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerDataaccess2LogicCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerDataaccess2LogicCheck.java",
        new DevonArchitectureLayerDataaccess2LogicCheck());
  }

}
