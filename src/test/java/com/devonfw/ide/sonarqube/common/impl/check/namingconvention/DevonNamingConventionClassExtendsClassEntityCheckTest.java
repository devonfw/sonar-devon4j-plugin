package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
 */
public class DevonNamingConventionClassExtendsClassEntityCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEntityCase1Check.java",
        new DevonNamingConventionClassExtendsClassEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEntityCase2Check.java",
        new DevonNamingConventionClassExtendsClassEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
   */
  @Test
  public void testIssueCaseThree() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEntityCase3Check.java",
        new DevonNamingConventionClassExtendsClassEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
   */
  @Test
  public void testIssueCaseFour() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEntityCase4Check.java",
        new DevonNamingConventionClassExtendsClassEntityCheck());
  }

}
