package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerLogicServiceCheck;

/**
 * Test of {@link DevonArchitectureLayerLogicServiceCheck}.
 */
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
