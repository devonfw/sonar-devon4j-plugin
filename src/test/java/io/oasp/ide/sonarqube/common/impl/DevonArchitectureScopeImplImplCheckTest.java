package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeImplImplCheck}.
 */
public class DevonArchitectureScopeImplImplCheckTest {

  /**
   * Test the {@link DevonArchitectureScopeImplImplCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeImplImplCheck.java",
        new DevonArchitectureScopeImplImplCheck());
  }

}