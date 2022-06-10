package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionCtoCheck}
 */
public class DevonNamingConventionCtoCheckTest {

  /**
   * Test of {@link DevonNamingConventionCtoCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionCtoCase1Check.java",
        new DevonNamingConventionCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionCtoCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionCtoCase3Check.java",
        new DevonNamingConventionCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionCtoCheck}
   */
  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionCtoCase4Check.java",
        new DevonNamingConventionCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionCtoCheck}
   */
  @Test
  public void testIssueCaseTwo() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionCtoCase2Check.java",
        new DevonNamingConventionCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionCtoCheck}
   */
  @Test
  public void testIssueCaseSix() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionCtoCase6Check.java",
        new DevonNamingConventionCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionCtoCheck}
   */
  @Test
  public void testNoIssueCaseFive() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionCtoCase5Check.java",
        new DevonNamingConventionCtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionCtoCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionCtoCheck());
  }

}
