package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
 */
public class DevonNamingConventionClassExtendsClassEtoCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassEtoCase1Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassEtoCase3Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testIssueCaseTwo() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassEtoCase2Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testIssueCaseFour() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassEtoCase4Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
  *
  */
  @Test
  public void testIssueCaseFive() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassEtoCase5Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

}
