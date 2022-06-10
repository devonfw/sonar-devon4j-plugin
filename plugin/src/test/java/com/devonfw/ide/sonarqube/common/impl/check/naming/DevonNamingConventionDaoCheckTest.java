package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionDaoCheck}
 */
public class DevonNamingConventionDaoCheckTest {

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test1() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionDaoCase1Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test2() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionDaoCase2Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test3() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionDaoCase3Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test4() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionDaoCase4Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test5() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionDaoCase5Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test6() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionDaoCase6Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test7() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionDaoCase7Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test8() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionDaoCase8Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test9() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionDaoCase9Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void test10() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionDaoCase10Check.java",
        new DevonNamingConventionDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionDaoCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionDaoCheck());
  }

}
