package com.devonfw.ide.sonarqube.common.impl.check;

/**
 * @author ssabah
 *
 */

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureScopeApiBaseCheck;

/**
 * Test of {@link DevonArchitectureScopeApiBaseCheck}.
 */
public class DevonArchitectureScopeApiBaseCheckTest {

  /**
   * Test the {@link DevonArchitectureScopeApiBaseCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeApiBaseCheck.java",
        new DevonArchitectureScopeApiBaseCheck());
  }

}
