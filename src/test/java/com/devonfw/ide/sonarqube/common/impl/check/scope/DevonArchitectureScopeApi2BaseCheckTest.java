package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeApi2BaseCheck}.
 */
public class DevonArchitectureScopeApi2BaseCheckTest {

  /**
   * Test the {@link DevonArchitectureScopeApi2BaseCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeApi2BaseCheck.java",
        new DevonArchitectureScopeApi2BaseCheck());
  }

}
