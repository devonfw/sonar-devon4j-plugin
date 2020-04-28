package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerBatch2Logic4ComponentCheck}.
 */
public class DevonArchitectureLayerBatch2Logic4ComponentCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerBatch2Logic4ComponentCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/component/DevonArchitectureLayerBatch2Logic4ComponentCheck.java",
        new DevonArchitectureLayerBatch2Logic4ComponentCheck());
  }

  /**
   * Test of {@link DevonArchitectureLayerBatch2Logic4ComponentCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonArchitectureLayerBatch2Logic4ComponentCheck());
  }

}
