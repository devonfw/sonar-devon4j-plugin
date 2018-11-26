package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeBaseImplCheck;

/**
 * Test of {@link DevonArchitectureScopeBaseImplCheck}.
 */
public class DevonArchitectureScopeBaseImplCheckTest {

  /**
   * Test of {@link DevonArchitectureScopeBaseImplCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeBaseImplCheck.java",
        new DevonArchitectureScopeBaseImplCheck());
  }

}
