package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeApiImplCheck}.
 */
public class DevonArchitectureScopeApiImplCheckTest {

  /**
   * Test the {@link DevonArchitectureScopeApiImplCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeApiImplCheck.java",
        new DevonArchitectureScopeApiImplCheck());
  }

}