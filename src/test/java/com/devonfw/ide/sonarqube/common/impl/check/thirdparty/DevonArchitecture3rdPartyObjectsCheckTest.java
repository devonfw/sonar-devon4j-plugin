package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyObjectsCheck}.
 */
public class DevonArchitecture3rdPartyObjectsCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyObjectsCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyObjectsCheck.java",
        new DevonArchitecture3rdPartyObjectsCheck());
  }

}
