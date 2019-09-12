package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
 */
public class DevonNamingConventionClassExtendsClassDaoCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassDaoCase1Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassDaoCase3Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassDaoCase4Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testCaseOne() {

    JavaCheckVerifier.verify("src/test/files/namingconvention/DevonNamingConventionClassExtendsClassDaoCase2Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }
}
