package com.devonfw.ide.sonarqube.common.impl.check;

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
  public void case1() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonUcImplSecurityConstraintCheckCase1.java",
        new DevonUcImplSecurityConstraintCheck());
  }

  // /**
  // * Test of {@link DevonUcImplSecurityConstraintCheckTest}
  // */
  // @Test
  // public void case2() {
  //
  // JavaCheckVerifier.verifyNoIssue("src/test/files/DevonUcImplSecurityConstraintCheckCase2.java",
  // new DevonUcImplSecurityConstraintCheck());
  // }

}
