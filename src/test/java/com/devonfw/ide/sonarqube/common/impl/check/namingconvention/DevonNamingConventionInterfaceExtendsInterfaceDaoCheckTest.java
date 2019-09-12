package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceDaoCheck}
 */
public class DevonNamingConventionInterfaceExtendsInterfaceDaoCheckTest {

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceDaoCheck}
   */
  @Test
  public void testNoIssueOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase1Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceDaoCheck}
   */
  @Test
  public void testNoIssueTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase2Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceDaoCheck}
   */
  @Test
  public void testNoIssueThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase3Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceDaoCheck}
   */
  @Test
  public void testIssueOneOnFile() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase4Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

}
