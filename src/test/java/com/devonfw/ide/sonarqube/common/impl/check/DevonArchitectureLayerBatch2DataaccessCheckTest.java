package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerBatch2DataaccessCheck}.
 */
public class DevonArchitectureLayerBatch2DataaccessCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerBatch2DataaccessCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerBatch2DataaccessCheck.java",
        new DevonArchitectureLayerBatch2DataaccessCheck());

  }

}
