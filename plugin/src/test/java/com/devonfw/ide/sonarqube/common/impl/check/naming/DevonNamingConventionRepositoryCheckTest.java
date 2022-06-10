package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionRepositoryCheck}
 */
public class DevonNamingConventionRepositoryCheckTest {

  /**
   * Test of {@link DevonNamingConventionRepositoryCheck}
   */
  @Test
  public void test1() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionRepositoryCase1Check.java",
        new DevonNamingConventionRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionRepositoryCheck}
   */
  @Test
  public void test2() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionRepositoryCase2Check.java",
        new DevonNamingConventionRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionRepositoryCheck}
   */
  @Test
  public void test3() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionRepositoryCase3Check.java",
        new DevonNamingConventionRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionRepositoryCheck}
   */
  @Test
  public void test4() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionRepositoryCase4Check.java",
        new DevonNamingConventionRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionRepositoryCheck}
   */
  @Test
  public void test5() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionRepositoryCase5Check.java",
        new DevonNamingConventionRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionRepositoryCheck}
   */
  @Test
  public void test6() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionRepositoryCase6Check.java",
        new DevonNamingConventionRepositoryCheck());
  }

  /**
   * Test of {@link DevonNamingConventionRepositoryCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionRepositoryCheck());
  }

}
