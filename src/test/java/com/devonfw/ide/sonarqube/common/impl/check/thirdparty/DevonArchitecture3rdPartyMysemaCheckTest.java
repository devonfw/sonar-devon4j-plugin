package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyMysemaCheck}.
 */
public class DevonArchitecture3rdPartyMysemaCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyMysemaCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyMysemaCheck.java",
        new DevonArchitecture3rdPartyMysemaCheck());
  }

}
