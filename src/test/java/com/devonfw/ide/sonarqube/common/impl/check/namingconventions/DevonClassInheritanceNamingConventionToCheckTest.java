package com.devonfw.ide.sonarqube.common.impl.check.namingconventions;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonNamingConventionClassExtendsClassToCheck;

/**
 * @author vhacimuf
 *
 */
public class DevonClassInheritanceNamingConventionToCheckTest {
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionToCase1Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionToCase3Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionToCase4Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionToCase5Check.java",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionToCase2Check.java",
        "Classes inheriting from AbstractTo should have [^CEce]To$ as prefix",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionToCase6Check.java",
        "If a superclass has[^CEce]To$ as prefix, then the subclass should also have[^CEce]To$ as prefix.",
        new DevonNamingConventionClassExtendsClassToCheck());
  }

}
