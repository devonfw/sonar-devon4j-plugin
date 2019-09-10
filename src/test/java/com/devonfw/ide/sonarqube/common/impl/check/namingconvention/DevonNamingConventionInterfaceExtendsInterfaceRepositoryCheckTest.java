package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
 */
public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheckTest {

  // /**
  // * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
  // */
  // @Test
  // public void testNoIssueOne() {
  //
  // JavaCheckVerifier.verifyNoIssue(
  // "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase1Check.java",
  // new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  // }
  //
  // /**
  // * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
  // */
  // @Test
  // public void testNoIssueTwo() {
  //
  // JavaCheckVerifier.verifyNoIssue(
  // "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase2Check.java",
  // new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  // }

  // /**
  // * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
  // */
  // @Test
  // public void testNoIssueThree() {
  //
  // JavaCheckVerifier.verifyNoIssue(
  // "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase3Check.java",
  // new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  // }

  // /**
  // * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
  // */
  // @Test
  // public void testIssueOneOnFile() {
  //
  // JavaCheckVerifier.verifyIssueOnFile(
  // "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase4Check.java",
  // "Interfaces inheriting from DefaultRepository should have Repository$ as suffix",
  // new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  // }

  // /**
  // * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
  // */
  // @Test
  // public void testIssueTwoOnFile() {
  //
  // JavaCheckVerifier.verifyIssueOnFile(
  // "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase5Check.java",
  // "If a superinterface has Repository$ as suffix, then the subinterface should also have Repository$ as suffix",
  // new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  // }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void TestNoIsseFour() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase6Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

}
