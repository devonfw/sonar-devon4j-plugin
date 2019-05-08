package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author vhacimuf
 *
 */
public class DevonNamingConventionInterfaceExtendsInterfaceDaoCheckTest {

  @Test
  public void testNoIssueOne() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase1Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  @Test
  public void testNoIssueTwo() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase2Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  @Test
  public void testNoIssueThree() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase3Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  @Test
  public void testIssueOneOnFile() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceDaoCase4Check.java",
        "Interfaces inheriting from Dao should have Dao$ as prefix",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

}
