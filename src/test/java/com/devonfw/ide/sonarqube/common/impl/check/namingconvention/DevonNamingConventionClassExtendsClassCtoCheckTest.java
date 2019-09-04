package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class DevonNamingConventionClassExtendsClassCtoCheckTest {

  /*
   * @Test public void testNoIssueCaseOne() {
   * 
   * JavaCheckVerifier.verifyNoIssue(
   * "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase1Check.java", new
   * DevonNamingConventionClassExtendsClassCtoCheck()); }
   */
  /*
   * @Test public void testNoIssueCaseTwo() {
   *
   * JavaCheckVerifier.verifyNoIssue(
   * "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase3Check.java", new
   * DevonNamingConventionClassExtendsClassCtoCheck()); }
   *
   * @Test public void testNoIssueCaseThree() {
   *
   * JavaCheckVerifier.verifyNoIssue(
   * "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase4Check.java", new
   * DevonNamingConventionClassExtendsClassCtoCheck()); }
   *
   * @Test public void testIssueOnFileCaseOne() {
   *
   * JavaCheckVerifier.verifyIssueOnFile(
   * "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase2Check.java",
   * "Classes inheriting from AbstractCto should have Cto$ as prefix", new
   * DevonNamingConventionClassExtendsClassCtoCheck()); }
   */

  @Test
  public void testNoIssueCaseFive() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/namingconvention/DevonNamingConventionClassExtendsClassCtoCase5Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

}
