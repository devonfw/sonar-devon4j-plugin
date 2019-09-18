package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassCtoCheck}
 */
public class DevonNamingConventionClassExtendsClassCtoCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassCtoCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase1Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassCtoCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase3Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassCtoCheck}
   */
  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase4Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassCtoCheck}
   */
  @Test
  public void testIssueCaseTwo() {

    JavaCheckVerifier.verify("src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase2Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassCtoCheck}
   */
  @Test
  public void testIssueCaseSix() {

    JavaCheckVerifier.verify("src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase6Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassCtoCheck}
   */
  @Test
  public void testNoIssueCaseFive() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase5Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

}
