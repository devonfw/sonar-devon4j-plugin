package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeBaseImplCheck}.
 */
public class DevonArchitectureScopeBaseImplCheckTest {

  /**
   * Test the {@link DevonArchitectureScopeBaseImplCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeBaseImplCheck.java",
        new DevonArchitectureScopeBaseImplCheck());
  }

}