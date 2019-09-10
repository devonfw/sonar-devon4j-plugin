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

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassSearchCriteriaToCase2Check.java",
        "Classes inheriting from AbstractSearchCriteriaTo should have SearchCriteriaTo$ as prefix",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
   */
  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassSearchCriteriaToCase4Check.java",
        "If a superclass has SearchCriteriaTo$ as prefix, then the subclass should also have SearchCriteriaTo$ as prefix.",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

}
