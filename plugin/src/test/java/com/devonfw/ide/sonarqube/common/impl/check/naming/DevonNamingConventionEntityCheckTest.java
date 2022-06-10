package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionEntityCheck}
 */
public class DevonNamingConventionEntityCheckTest {

  /**
   * Test of {@link DevonNamingConventionEntityCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionEntityCase1Check.java",
        new DevonNamingConventionEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionEntityCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionEntityCase2Check.java",
        new DevonNamingConventionEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionEntityCheck}
   */
  @Test
  public void testIssueCaseThree() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionEntityCase3Check.java",
        new DevonNamingConventionEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionEntityCheck}
   */
  @Test
  public void testIssueCaseFour() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionEntityCase4Check.java",
        new DevonNamingConventionEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionEntityCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionEntityCheck());
  }

}
