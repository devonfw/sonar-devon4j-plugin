package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionToCheck}
 */
public class DevonNamingConventionToCheckTest {

  /**
   * Test of {@link DevonNamingConventionToCheck}
   */
  @Test
  public void test1() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionToCase1Check.java",
        new DevonNamingConventionToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionToCheck}
   */
  @Test
  public void test2() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionToCase2Check.java",
        new DevonNamingConventionToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionToCheck}
   */
  @Test
  public void test3() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionToCase3Check.java",
        new DevonNamingConventionToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionToCheck}
   */
  @Test
  public void test4() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionToCase4Check.java",
        new DevonNamingConventionToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionToCheck}
   */
  @Test
  public void test5() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionToCase5Check.java",
        new DevonNamingConventionToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionToCheck}
   */
  @Test
  public void test6() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionToCase6Check.java",
        new DevonNamingConventionToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionToCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionToCheck());
  }

}
