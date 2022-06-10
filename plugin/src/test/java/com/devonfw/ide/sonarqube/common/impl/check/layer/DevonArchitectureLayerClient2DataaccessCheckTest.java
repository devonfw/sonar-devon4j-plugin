package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerClient2DataaccessCheck}.
 */
public class DevonArchitectureLayerClient2DataaccessCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerClient2DataaccessCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/layer/DevonArchitectureLayerClient2DataaccessCheck.java",
        new DevonArchitectureLayerClient2DataaccessCheck());
  }

}
