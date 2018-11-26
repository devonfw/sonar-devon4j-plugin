package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeBaseBaseCheck;

/**
 * Test of {@link DevonArchitectureScopeBaseBaseCheck}.
 */
public class DevonArchitectureScopeBaseBaseCheckTest {

  /**
   * Test of {@link DevonArchitectureScopeBaseBaseCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeBaseBaseCheck.java",
        new DevonArchitectureScopeBaseBaseCheck());
  }

}
