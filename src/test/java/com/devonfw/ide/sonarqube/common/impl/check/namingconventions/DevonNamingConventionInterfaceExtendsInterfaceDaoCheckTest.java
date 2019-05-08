package com.devonfw.ide.sonarqube.common.impl.check.namingconventions;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonNamingConventionInterfaceExtendsInterfaceDaoCheck;

/**
 * @author vhacimuf
 *
 */
public class DevonNamingConventionInterfaceExtendsInterfaceDaoCheckTest {

  @Test
  public void testNoIssueOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNamingConventionInterfaceExtendsInterfaceDaoCase1Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  @Test
  public void testNoIssueTwo() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNamingConventionInterfaceExtendsInterfaceDaoCase2Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  @Test
  public void testNoIssueThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonNamingConventionInterfaceExtendsInterfaceDaoCase3Check.java",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

  @Test
  public void testIssueOneOnFile() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/DevonNamingConventionInterfaceExtendsInterfaceDaoCase4Check.java",
        "Interfaces inheriting from Dao should have Dao$ as prefix",
        new DevonNamingConventionInterfaceExtendsInterfaceDaoCheck());
  }

}
