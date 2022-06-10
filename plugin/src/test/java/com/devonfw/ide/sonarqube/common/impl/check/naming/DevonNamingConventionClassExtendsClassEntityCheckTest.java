package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
 */
public class DevonNamingConventionClassExtendsClassEntityCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassEntityCase1Check.java",
        new DevonNamingConventionClassExtendsClassEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassEntityCase2Check.java",
        new DevonNamingConventionClassExtendsClassEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
   */
  @Test
  public void testIssueCaseThree() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassEntityCase3Check.java",
        new DevonNamingConventionClassExtendsClassEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
   */
  @Test
  public void testIssueCaseFour() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassEntityCase4Check.java",
        new DevonNamingConventionClassExtendsClassEntityCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEntityCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionClassExtendsClassEntityCheck());
  }

}
