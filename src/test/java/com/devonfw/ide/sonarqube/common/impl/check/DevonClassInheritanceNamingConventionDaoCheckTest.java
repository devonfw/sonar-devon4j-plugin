package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author vhacimuf
 *
 */
public class DevonClassInheritanceNamingConventionDaoCheckTest {
  @Test
  public void testNoIssueCaseOne() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionDaoCase1Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  @Test
  public void testNoIssueCaseTwo() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionDaoCase3Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  @Test
  public void testNoIssueCaseThree() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonClassInheritanceNamingConventionDaoCase4Check.java",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }

  @Test
  public void testIssueOnFileCaseOne() {

    JavaCheckVerifier.verifyIssueOnFile("src/test/files/DevonClassInheritanceNamingConventionDaoCase2Check.java",
        "Classes inheriting from AbstractDao should have DaoImpl$ as prefix",
        new DevonNamingConventionClassExtendsClassDaoCheck());
  }
}
