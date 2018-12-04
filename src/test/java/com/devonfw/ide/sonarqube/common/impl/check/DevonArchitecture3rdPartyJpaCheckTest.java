package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyJpaCheck}.
 */
public class DevonArchitecture3rdPartyJpaCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyJpaCheck}.
   */
  @Test
  public void testNOK() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitecture3rdPartyJpaCheck_NOK.java",
        new DevonArchitecture3rdPartyJpaCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyJpaCheck}.
   */
  @Test
  public void testOK() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonArchitecture3rdPartyJpaCheck_OK.java",
        new DevonArchitecture3rdPartyJpaCheck());
  }

}
