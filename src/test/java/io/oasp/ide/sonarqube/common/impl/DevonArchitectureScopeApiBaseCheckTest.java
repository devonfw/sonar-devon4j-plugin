package io.oasp.ide.sonarqube.common.impl;

/**
 * @author ssabah
 *
 */

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

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
