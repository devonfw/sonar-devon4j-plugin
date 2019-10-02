package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeApi2ImplCheck}.
 */
public class DevonArchitectureScopeApi2ImplCheckTest {

  /**
   * Test the {@link DevonArchitectureScopeApi2ImplCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeApi2ImplCheck.java",
        new DevonArchitectureScopeApi2ImplCheck());
  }

}