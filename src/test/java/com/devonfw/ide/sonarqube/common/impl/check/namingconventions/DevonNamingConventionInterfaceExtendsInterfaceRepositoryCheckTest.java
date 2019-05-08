package com.devonfw.ide.sonarqube.common.impl.check.namingconventions;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck;

public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheckTest {

  @Test
  public void testNoIssueOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase1Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  @Test
  public void testNoIssueTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase2Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  @Test
  public void testNoIssueThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase3Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  @Test
  public void testIssueOneOnFile() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase4Check.java",
        "Interfaces inheriting from DefaultRepository should have Repository$ as prefix",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  @Test
  public void testIssueTwoOnFile() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase5Check.java",
        "If a superinterface has Repository$ as prefix, then the subinteraface should also haveRepository$ as prefix.",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }
}
