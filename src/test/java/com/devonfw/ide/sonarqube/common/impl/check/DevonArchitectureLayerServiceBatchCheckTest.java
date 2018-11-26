package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerServiceBatchCheck;

/**
 * Test of {@link DevonArchitectureLayerServiceBatchCheck}.
 */
public class DevonArchitectureLayerServiceBatchCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerServiceBatchCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerServiceBatchCheck.java",
        new DevonArchitectureLayerServiceBatchCheck());
  }

}
