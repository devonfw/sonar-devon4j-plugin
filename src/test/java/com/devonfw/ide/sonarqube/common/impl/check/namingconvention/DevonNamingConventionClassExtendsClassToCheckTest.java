package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author vhacimuf
 *
 */
public class DevonNamingConventionClassExtendsClassToCheckTest {
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase1Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase3Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase4Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase5Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase2Check.java",
        "Classes inheriting from AbstractTo should have [^CEce]To$ as prefix",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassToCase6Check.java",
        "If a superclass has [^CEce]To$ as prefix, then the subclass should also have [^CEce]To$ as prefix.",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

}
