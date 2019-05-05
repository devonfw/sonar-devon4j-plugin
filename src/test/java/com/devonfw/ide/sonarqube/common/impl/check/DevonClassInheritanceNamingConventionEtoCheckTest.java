package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author vhacimuf
 *
 */
public class DevonClassInheritanceNamingConventionEtoCheckTest {
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionEtoCase1Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionEtoCase3Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionEtoCase3Check.java",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionEtoCase2Check.java",
        "Classes inheriting from AbstractEto should have Eto$ as prefix",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }

  @Test
  public void testIssueOnFileCaseTwo() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionEtoCase4Check.java",
        "If a superclass hasEto$ as prefix, then the subclass should also haveEto$ as prefix.",
        new DevonNamingConventionClassExtendsClassEtoCheck());
  }
}
