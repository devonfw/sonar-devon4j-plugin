package com.devonfw.ide.sonarqube.common.impl.check.naming;

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
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase1Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceDaoCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase2Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceDaoCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase3Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceDaoCheck}
   */
  @Test
  public void testIssueCaseFour() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase4Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

}
