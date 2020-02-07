package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyJpaCheck}.
 */
public class DevonArchitecture3rdPartyJpaCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyJpaCheck} verifies that the use of JPA outside of the dataaccess layer or
   * for embeddables in the common layer is not allowed.
   */
  @Test
  public void testNOK() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyJpaCheck_NOK.java",
        new DevonArchitecture3rdPartyJpaCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyJpaCheck} verifies that the use of JPA in the dataaccess layer is not
   * flagged.
   */
  @Test
  public void testOKDataaccess() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/thirdparty/DevonArchitecture3rdPartyJpaCheck_OKDataaccess.java",
        new DevonArchitecture3rdPartyJpaCheck());
  }

  /**
   * TODO: source.getSimpleName() returns null. Implement a way to get the name of the class currently being
   * investigated.
   *
   * Test of {@link DevonArchitecture3rdPartyJpaCheck} verifies that the use of JPA for embeddables in the common layer
   * is not flagged.
   */
  // @Test
  // public void testOKCommon() {
  //
  // JavaCheckVerifier.verifyNoIssue("src/test/files/thirdparty/DevonArchitecture3rdPartyJpaCheck_OKCommon.java",
  // new DevonArchitecture3rdPartyJpaCheck());
  // }

}
