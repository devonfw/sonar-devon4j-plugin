package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author vhacimuf
 *
 */
public class DevonClassInheritanceNamingConventionCtoCheckTest {
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionCtoCase1Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionCtoCase3Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionCtoCase4Check.java",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }

  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionCtoCase2Check.java",
        "Classes inheriting from AbstractCto should have Cto$ as prefix",
        new DevonNamingConventionClassExtendsClassCtoCheck());
  }
}
