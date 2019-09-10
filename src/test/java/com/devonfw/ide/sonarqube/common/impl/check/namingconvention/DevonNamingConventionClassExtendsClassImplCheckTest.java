package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
 */
public class DevonNamingConventionClassExtendsClassImplCheckTest {

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase1Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase3Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase4Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase5Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase2Check.java",
        "Classes inheriting from AbstractUc should have Uc.*Impl$ as prefix",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase6Check.java",
        "If a superclass has Uc.*Impl$ as prefix, then the subclass should also have Uc.*Impl$ as prefix.",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassImplCheck}
   */
  @Test
  public void testIssueOnFileCaseThree() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassImplCase7Check.java",
        "Classes inheriting from AbstractUc should not be abstract",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

}
