package com.devonfw.ide.sonarqube.common.impl.check.naming;

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
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase1Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase2Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase3Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void testIssueCaseFour() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase4Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void testIssueCaseFive() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase5Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck}
   */
  @Test
  public void TestNoIssueCaseSix() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase6Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

}
