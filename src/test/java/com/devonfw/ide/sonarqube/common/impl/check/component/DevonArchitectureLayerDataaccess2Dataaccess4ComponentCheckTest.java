package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck}.
 */
public class DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/component/DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck.java",
        new DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck());
  }

  /**
   * Test of {@link DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck());
  }

}
