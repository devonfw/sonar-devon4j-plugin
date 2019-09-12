package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
 */
public class DevonNamingConventionClassExtendsClassSearchCriteriaCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassSearchCriteriaToCase1Check.java",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassSearchCriteriaToCase3Check.java",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
   */
  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassSearchCriteriaToCase2Check.java",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
   */
  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verify(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassSearchCriteriaToCase4Check.java",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

}
