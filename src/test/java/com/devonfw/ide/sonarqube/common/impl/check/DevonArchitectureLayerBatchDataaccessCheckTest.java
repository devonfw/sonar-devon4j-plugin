package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerBatchDataaccessCheck;

/**
 * Test of {@link DevonArchitectureLayerBatchDataaccessCheck}.
 */
public class DevonArchitectureLayerBatchDataaccessCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerBatchDataaccessCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerBatchDataaccessCheck.java",
        new DevonArchitectureLayerBatchDataaccessCheck());

  }

}
