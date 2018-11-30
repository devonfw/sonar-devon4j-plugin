package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureComponentDeclarationCheck}.
 */
public class DevonArchitectureComponentDeclarationCheckTest {

  /**
   * Test of {@link DevonArchitectureComponentDeclarationCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureComponentDeclarationCheck.java",
        new DevonArchitectureComponentDeclarationCheck());
  }

}
