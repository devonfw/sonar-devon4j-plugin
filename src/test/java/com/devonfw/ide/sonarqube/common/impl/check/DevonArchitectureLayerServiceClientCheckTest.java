package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerServiceClientCheck;

/**
 * Test of {@link DevonArchitectureLayerServiceClientCheck}.
 */
public class DevonArchitectureLayerServiceClientCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerServiceClientCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerServiceClientCheck.java",
        new DevonArchitectureLayerServiceClientCheck());
  }

}
