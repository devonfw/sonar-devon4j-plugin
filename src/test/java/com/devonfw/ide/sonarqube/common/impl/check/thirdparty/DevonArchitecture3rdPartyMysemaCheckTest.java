package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyMysemaCheck}.
 */
public class DevonArchitecture3rdPartyMysemaCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyMysemaCheck} verifies that the use of com.mysema.query.jpa.impl.JPAQuery is
   * not allowed.
   */
  @Test
  public void testNonCompliant() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyMysemaCheck_NotOK.java",
        new DevonArchitecture3rdPartyMysemaCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyMysemaCheck} verifies that the use of com.querydsl.jpa.impl.JPAQuery is not
   * flagged.
   */
  @Test
  public void testCompliant() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/thirdparty/DevonArchitecture3rdPartyMysemaCheck_OK.java",
        new DevonArchitecture3rdPartyMysemaCheck());
  }

}
