package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionUcCheck}
 */
public class DevonNamingConventionUcCheckTest {

  /**
   * Test of {@link DevonNamingConventionUcCheck}
   */
  @Test
  public void test1() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionUcCase1Check.java",
        new DevonNamingConventionUcCheck());
  }

  /**
   * Test of {@link DevonNamingConventionUcCheck}
   */
  @Test
  public void test2() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionUcCase2Check.java",
        new DevonNamingConventionUcCheck());
  }

  /**
   * Test of {@link DevonNamingConventionUcCheck}
   */
  @Test
  public void test3() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionUcCase3Check.java",
        new DevonNamingConventionUcCheck());
  }

  /**
   * Test of {@link DevonNamingConventionUcCheck}
   */
  @Test
  public void test4() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionUcCase4Check.java",
        new DevonNamingConventionUcCheck());
  }

  /**
   * Test of {@link DevonNamingConventionUcCheck}
   */
  @Test
  public void test5() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionUcCase5Check.java",
        new DevonNamingConventionUcCheck());
  }

  /**
   * Test of {@link DevonNamingConventionUcCheck}
   */
  @Test
  public void test6() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionUcCase6Check.java",
        new DevonNamingConventionUcCheck());
  }

  /**
   * Test of {@link DevonNamingConventionUcCheck}
   */
  @Test
  public void test7() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionUcCase7Check.java",
        new DevonNamingConventionUcCheck());
  }

  /**
   * Test of {@link DevonNamingConventionUcCheck}
   */
  @Test
  public void test8() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionUcCase8Check.java",
        new DevonNamingConventionUcCheck());
  }

  /**
   * Test of {@link DevonNamingConventionUcCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionUcCheck());
  }

}
