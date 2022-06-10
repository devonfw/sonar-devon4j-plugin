package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeBase2ImplCheck}.
 */
public class DevonArchitectureScopeBase2ImplCheckTest {

  /**
   * Test of {@link DevonArchitectureScopeBase2ImplCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/scope/DevonArchitectureScopeBase2ImplCheck.java",
        new DevonArchitectureScopeBase2ImplCheck());
  }

}
