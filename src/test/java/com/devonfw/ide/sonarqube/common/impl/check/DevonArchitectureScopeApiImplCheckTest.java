package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeApiImplCheck;

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