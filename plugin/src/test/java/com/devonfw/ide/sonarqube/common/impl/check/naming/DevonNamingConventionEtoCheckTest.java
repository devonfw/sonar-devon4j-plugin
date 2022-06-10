package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionEtoCheck}
 */
public class DevonNamingConventionEtoCheckTest {

  /**
   * Test of {@link DevonNamingConventionEtoCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionEtoCase1Check.java",
        new DevonNamingConventionEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionEtoCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionEtoCase3Check.java",
        new DevonNamingConventionEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionEtoCheck}
   */
  @Test
  public void testIssueCaseTwo() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionEtoCase2Check.java",
        new DevonNamingConventionEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionEtoCheck}
   */
  @Test
  public void testIssueCaseFour() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionEtoCase4Check.java",
        new DevonNamingConventionEtoCheck());
  }

  /**
  *
  */
  @Test
  public void testIssueCaseFive() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionEtoCase5Check.java",
        new DevonNamingConventionEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionEtoCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionEtoCheck());
  }

}
