package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

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

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEtoCase1Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEtoCase3Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEtoCase3Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEtoCase2Check.java",
        "Classes inheriting from AbstractEto should have Eto$ as suffix",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEtoCase4Check.java",
        "If a superclass has Eto$ as suffix, then the subclass should also have Eto$ as suffix.",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

}
