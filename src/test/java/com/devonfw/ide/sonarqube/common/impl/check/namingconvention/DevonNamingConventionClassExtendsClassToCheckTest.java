package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
 */
public class DevonNamingConventionClassExtendsClassToCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase1Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase3Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase4Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase5Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verify("src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase2Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verify("src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase6Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

}
