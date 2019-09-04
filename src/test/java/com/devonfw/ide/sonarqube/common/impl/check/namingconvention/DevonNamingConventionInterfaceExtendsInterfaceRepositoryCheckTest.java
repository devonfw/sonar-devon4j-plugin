package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheckTest {

  /*
   * @Test public void testNoIssueOne() {
   *
   * JavaCheckVerifier.verifyNoIssue(
   * "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase1Check.java", new
   * DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck()); }
   *
   * @Test public void testNoIssueTwo() {
   *
   * JavaCheckVerifier.verifyNoIssue(
   * "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase2Check.java", new
   * DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck()); }
   *
   * @Test public void testNoIssueThree() {
   *
   * JavaCheckVerifier.verifyNoIssue(
   * "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase3Check.java", new
   * DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck()); }
   */

  @Test
  public void testIssueOneOnFile() {

    JavaCheckVerifier.verifyIssueOnFile(
        "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase4Check.java",
        "Interfaces inheriting from DefaultRepository should have Repository$ as prefix",
        new DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck());
  }

  /*
   * @Test public void testIssueTwoOnFile() {
   * 
   * JavaCheckVerifier.verifyIssueOnFile(
   * "src/test/files/namingconvention/DevonNamingConventionInterfaceExtendsInterfaceRepositoryCase5Check.java",
   * "If a superinterface has Repository$ as prefix, then the subinteraface should also haveRepository$ as prefix.", new
   * DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck()); }
   */

}
