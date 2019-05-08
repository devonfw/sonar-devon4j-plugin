package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class DevonNamingConventionClassExtendsClassDaoCheckTest {
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassDaoCase1Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassDaoCase3Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassDaoCase4Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassDaoCase2Check.java",
        "Classes inheriting from AbstractDao should have DaoImpl$ as prefix",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }
}
