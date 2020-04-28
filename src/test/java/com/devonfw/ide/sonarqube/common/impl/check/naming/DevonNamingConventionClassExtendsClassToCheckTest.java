package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
 */
public class DevonNamingConventionClassExtendsClassToCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassToCase1Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassToCase3Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassToCase4Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testNoIssueCaseFive() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassToCase5Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testIssueCaseTwo() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassToCase2Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testIssueCaseSix() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassToCase6Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassToCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

}
