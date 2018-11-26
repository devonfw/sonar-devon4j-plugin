package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerDataaccessLogicCheck;

/**
 * Test of {@link DevonArchitectureLayerDataaccessLogicCheck}.
 */
public class DevonArchitectureLayerDataaccessLogicCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerDataaccessLogicCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerDataaccessLogicCheck.java",
        new DevonArchitectureLayerDataaccessLogicCheck());
  }

}
