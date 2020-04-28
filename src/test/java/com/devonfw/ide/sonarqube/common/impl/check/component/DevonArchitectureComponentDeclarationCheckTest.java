package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureComponentDeclarationCheck}.
 */
public class DevonArchitectureComponentDeclarationCheckTest {

  /**
   * Test of {@link DevonArchitectureComponentDeclarationCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/component/DevonArchitectureComponentDeclarationCheck_NotOK.java",
        new DevonArchitectureComponentDeclarationCheck());
  }

  /**
   * Test of {@link DevonArchitectureComponentDeclarationCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonArchitectureComponentDeclarationCheck());
  }

}
