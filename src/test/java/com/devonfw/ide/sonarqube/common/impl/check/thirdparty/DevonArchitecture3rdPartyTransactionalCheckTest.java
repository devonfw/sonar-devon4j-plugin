package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyTransactionalCheck}.
 */
public class DevonArchitecture3rdPartyTransactionalCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyTransactionalCheck} verifies that the use of
   * org.springframework.transaction.annotation.Transactional is not allowed.
   */
  @Test
  public void testSpringTransactional() {

    JavaCheckVerifier.verify(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyTransactionalCheck_SpringTransactional.java",
        new DevonArchitecture3rdPartyTransactionalCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyTransactionalCheck} verifies that the use of
   * javax.transaction.Transactional in the api scope is not allowed.
   */
  @Test
  public void testJavaxTransactionalInApiScope() {

    JavaCheckVerifier.verify(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyTransactionalCheck_JavaxTransactionalInApiScope.java",
        new DevonArchitecture3rdPartyTransactionalCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyTransactionalCheck} verifies that the use of
   * javax.transaction.Transactional outside of api scope is not flagged.
   */
  @Test
  public void testCompliant() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/thirdparty/DevonArchitecture3rdPartyTransactionalCheck_OK.java",
        new DevonArchitecture3rdPartyTransactionalCheck());
  }

}
