package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.security.DevonUcImplSecurityConstraintCheck;

/**
 * Test of {@link DevonUcImplSecurityConstraintCheck}
 */
public class DevonUcImplSecurityConstraintCheckTest {

  /**
   * Test of {@link DevonUcImplSecurityConstraintCheckTest}
   */
  @Test
  public void nonCompliantCase() {

    JavaCheckVerifier.verify("src/test/files/DevonUcImplSecurityConstraintCheckNonCompliantCase.java",
        new DevonUcImplSecurityConstraintCheck());
  }

  /**
   * Test of {@link DevonUcImplSecurityConstraintCheckTest}
   */
  @Test
  public void denyAllCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonUcImplSecurityConstraintCheckDenyAllCase.java",
        new DevonUcImplSecurityConstraintCheck());
  }

  /**
   * Test of {@link DevonUcImplSecurityConstraintCheckTest}
   */
  @Test
  public void rolesAllowedCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonUcImplSecurityConstraintCheckRolesAllowedCase.java",
        new DevonUcImplSecurityConstraintCheck());
  }

  /**
   * Test of {@link DevonUcImplSecurityConstraintCheckTest}
   */
  @Test
  public void permitAllCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonUcImplSecurityConstraintCheckPermitAllCase.java",
        new DevonUcImplSecurityConstraintCheck());
  }

}