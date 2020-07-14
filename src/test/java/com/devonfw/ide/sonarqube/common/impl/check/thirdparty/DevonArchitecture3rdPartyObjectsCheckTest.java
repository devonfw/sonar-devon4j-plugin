package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyObjectsCheck}.
 */
public class DevonArchitecture3rdPartyObjectsCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyObjectsCheck} verifies that the use of com.google.common.base.Objects is
   * not allowed.
   */
  @Test
  public void testNonCompliant() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyObjectsCheck_NotOK.java",
        new DevonArchitecture3rdPartyObjectsCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyObjectsCheck} verifies that the use of java.util.Objects is not flagged.
   */
  @Test
  public void testCompliant() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/thirdparty/DevonArchitecture3rdPartyObjectsCheck_OK.java",
        new DevonArchitecture3rdPartyObjectsCheck());
  }

}
