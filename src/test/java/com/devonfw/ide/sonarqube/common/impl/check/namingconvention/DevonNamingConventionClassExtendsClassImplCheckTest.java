package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
 */
public class DevonNamingConventionClassExtendsClassImplCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase1Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase3Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase4Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testNoIssueCaseFive() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase5Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testIssueCaseTwo() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase2Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testIssueCaseSeven() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase7Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

}
