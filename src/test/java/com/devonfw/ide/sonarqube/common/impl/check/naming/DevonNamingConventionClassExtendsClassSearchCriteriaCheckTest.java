package com.devonfw.ide.sonarqube.common.impl.check.naming;

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
        "src/test/files/naming/DevonNamingConventionClassExtendsClassSearchCriteriaToCase1Check.java",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/naming/DevonNamingConventionClassExtendsClassSearchCriteriaToCase3Check.java",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
   */
  @Test
  public void testIssueCaseTwo() {

    JavaCheckVerifier.verify(
        "src/test/files/naming/DevonNamingConventionClassExtendsClassSearchCriteriaToCase2Check.java",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
   */
  @Test
  public void testIssueCaseFour() {

    JavaCheckVerifier.verify(
        "src/test/files/naming/DevonNamingConventionClassExtendsClassSearchCriteriaToCase4Check.java",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassSearchCriteriaToCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionClassExtendsClassSearchCriteriaToCheck());
  }

}
