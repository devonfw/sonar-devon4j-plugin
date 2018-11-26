package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeImplImplCheck;

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