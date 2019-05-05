package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author vhacimuf
 *
 */
public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheckTest {

  @Test
  public void testNoIssueOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceRepositoryNoIssueOneCheck.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  @Test
  public void testNoIssueTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceRepositoryNoIssueTwoCheck.java",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  @Test
  public void testIssueOneOnFile() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceRepositoryIssueOneCheck.java",
        "Interfaces inheriting from DefaultRepository should have Repository$ as prefix",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  @Test
  public void testIssueTwoOnFile() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceRepositoryIssueTwoCheck.java",
        "If a superinterface has Repository$ as prefix, then the subinteraface should also haveRepository$ as prefix.",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }
}
