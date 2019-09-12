package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
 */
public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheckTest {

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void testNoIssueOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase1Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void testNoIssueTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase2Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void testNoIssueThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase3Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void testIssueOneOnFile() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase4Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void testIssueTwoOnFile() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase5Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void TestNoIssueFour() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase6Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

}
