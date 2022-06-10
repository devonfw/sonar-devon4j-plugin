package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureComponentDependencyCheck}.
 */
public class DevonArchitectureComponentDependencyCheckTest {

  /**
   * Test of {@link DevonArchitectureComponentDependencyCheck}.
   */
  @Test
  public void testNotOK() {

    JavaCheckVerifier.verify("src/test/files/component/DevonArchitectureComponentDependencyCheck_NotOK.java",
        new DevonArchitectureComponentDependencyCheck());
  }

  /**
   * Test of {@link DevonArchitectureComponentDependencyCheck}.
   */
  @Test
  public void testOK() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/component/DevonArchitectureComponentDependencyCheck_OK.java",
        new DevonArchitectureComponentDependencyCheck());
  }

  /**
   * Test of {@link DevonArchitectureComponentDependencyCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonArchitectureComponentDependencyCheck());
  }

}
