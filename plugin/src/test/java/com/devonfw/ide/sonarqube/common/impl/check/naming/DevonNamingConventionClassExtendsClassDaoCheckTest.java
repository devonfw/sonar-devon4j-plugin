package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
 */
public class DevonNamingConventionClassExtendsClassDaoCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassDaoCase1Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassDaoCase3Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/naming/DevonNamingConventionClassExtendsClassDaoCase4Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testIssueCaseTwo() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassDaoCase2Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testIssueCaseSix() {

    JavaCheckVerifier.verify("src/test/files/naming/DevonNamingConventionClassExtendsClassDaoCase6Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassDaoCheck}
   */
  @Test
  public void testPackageInfoCase() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNPEOnPackageInfoCheck.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

}
