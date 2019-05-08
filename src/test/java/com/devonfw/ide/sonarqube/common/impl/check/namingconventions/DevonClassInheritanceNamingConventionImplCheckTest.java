package com.devonfw.ide.sonarqube.common.impl.check.namingconventions;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonNamingConventionClassExtendsClassImplCheck;

public class DevonClassInheritanceNamingConventionImplCheckTest {
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
        "Classes inheriting from AbstractUc should have Uc.*Impl$ as prefix",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionToCase6Check.java",
        "If a superclass has Uc.*Impl$ as prefix, then the subclass should also haveUc.*Impl$ as prefix.",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

  @Test
  public void testIssueOnFileCaseThree() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionImplCase7Check.java",
        "Classes inheriting from AbstractUc should not be abstract",
        new DevonNamingConventionClassExtendsClassImplCheck());
  }

}
