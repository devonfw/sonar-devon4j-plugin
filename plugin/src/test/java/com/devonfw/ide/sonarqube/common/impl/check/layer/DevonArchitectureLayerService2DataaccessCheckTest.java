package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test the {@link DevonArchitectureLayerService2DataaccessCheck}.
 */
public class DevonArchitectureLayerService2DataaccessCheckTest {

  /**
   * Test the {@link DevonArchitectureLayerService2DataaccessCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/layer/DevonArchitectureLayerService2DataaccessCheck.java",
        new DevonArchitectureLayerService2DataaccessCheck());
  }

}
