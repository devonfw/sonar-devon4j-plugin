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
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verify("src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEtoCase2Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
   * Test of {@link DevonNamingConventionClassExtendsClassEtoCheck}
   */
  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verify("src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEtoCase4Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  /**
  *
  */
  @Test
  public void testCaseFive() {

    JavaCheckVerifier.verify("src/test/files/namingconvention/DevonNamingConventionClassExtendsClassEtoCase5Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

}
