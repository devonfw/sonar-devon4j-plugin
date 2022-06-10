package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionSearchCriteriaToCheck}
 */
public class DevonNamingConventionSearchCriteriaCheckTest {

  /**
   * Test of {@link DevonNamingConventionSearchCriteriaToCheck}
   */
  @Test
  public void test1() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionSearchCriteriaToCase1Check.java",
        new DevonNamingConventionSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionSearchCriteriaToCheck}
   */
  @Test
  public void test2() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionSearchCriteriaToCase2Check.java",
        new DevonNamingConventionSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionSearchCriteriaToCheck}
   */
  @Test
  public void test3() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionSearchCriteriaToCase3Check.java",
        new DevonNamingConventionSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionSearchCriteriaToCheck}
   */
  @Test
  public void test4() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionSearchCriteriaToCase4Check.java",
        new DevonNamingConventionSearchCriteriaToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionSearchCriteriaToCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionSearchCriteriaToCheck());
  }

}
