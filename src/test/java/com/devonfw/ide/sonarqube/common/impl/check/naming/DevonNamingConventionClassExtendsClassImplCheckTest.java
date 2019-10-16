package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassUcImplCheck}
 */
public class DevonNamingConventionClassExtendsClassImplCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassUcImplCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassImplCase1Check.java",
        new DevonNamingConventionClassExtendsClassUcImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassUcImplCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassImplCase3Check.java",
        new DevonNamingConventionClassExtendsClassUcImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassUcImplCheck}
   */
  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassImplCase4Check.java",
        new DevonNamingConventionClassExtendsClassUcImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassUcImplCheck}
   */
  @Test
  public void testNoIssueCaseFive() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassImplCase5Check.java",
        new DevonNamingConventionClassExtendsClassUcImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassUcImplCheck}
   */
  @Test
  public void testIssueCaseTwo() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassImplCase2Check.java",
        new DevonNamingConventionClassExtendsClassUcImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassUcImplCheck}
   */
  @Test
  public void testIssueCaseSeven() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassImplCase7Check.java",
        new DevonNamingConventionClassExtendsClassUcImplCheck());
  }

}
