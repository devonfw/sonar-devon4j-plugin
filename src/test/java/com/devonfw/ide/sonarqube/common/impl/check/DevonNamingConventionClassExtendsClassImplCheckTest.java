package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author vhacimuf
 *
 */
public class DevonNamingConventionClassExtendsClassImplCheckTest {
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionImplCase1Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionImplCase3Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionImplCase4Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  @Test
  public void testNoIssueCaseFour() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionImplCase5Check.java",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionImplCase2Check.java",
        "Classes inheriting from AbstractTo should have [^CEce]To$ as prefix",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionToCase6Check.java",
        "If a superclass has[^CEce]To$ as prefix, then the subclass should also have[^CEce]To$ as prefix.",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

}
