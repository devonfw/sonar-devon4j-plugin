package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerCommon2AnyCheck}.
 */
public class DevonArchitectureLayerCommon2AnyCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerCommon2AnyCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/layer/DevonArchitectureLayerCommon2AnyCheck.java",
        new DevonArchitectureLayerCommon2AnyCheck());
  }

}
