package com.devonfw.ide.sonarqube.common.impl.check.security;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonUcImplSecurityConstraintCheck}
 */
public class DevonUcImplSecurityConstraintCheckTest {

  /**
   * Test of {@link DevonUcImplSecurityConstraintCheckTest}
   */
  @Test
  public void nonCompliantCase() {

    JavaCheckVerifier.verify("src/test/files/security/DevonUcImplSecurityConstraintCheckNonCompliantCase.java",
        new DevonUcImplSecurityConstraintCheck());
  }

  /**
   * Test of {@link DevonUcImplSecurityConstraintCheckTest}
   */
  @Test
  public void denyAllCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/security/DevonUcImplSecurityConstraintCheckDenyAllCase.java",
        new DevonUcImplSecurityConstraintCheck());
  }

  /**
   * Test of {@link DevonUcImplSecurityConstraintCheckTest}
   */
  @Test
  public void rolesAllowedCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/security/DevonUcImplSecurityConstraintCheckRolesAllowedCase.java",
        new DevonUcImplSecurityConstraintCheck());
  }

  /**
   * Test of {@link DevonUcImplSecurityConstraintCheckTest}
   */
  @Test
  public void permitAllCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/security/DevonUcImplSecurityConstraintCheckPermitAllCase.java",
        new DevonUcImplSecurityConstraintCheck());
  }

  /**
   * Test of {@link DevonUcImplSecurityConstraintCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonUcImplSecurityConstraintCheck());
  }

}