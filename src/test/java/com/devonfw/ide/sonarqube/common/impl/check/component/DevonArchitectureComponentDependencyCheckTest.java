package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureComponentDependencyCheck}.
 */
public class DevonArchitectureComponentDependencyCheckTest {

  /**
   * Test of {@link DevonArchitectureComponentDependencyCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureComponentDependencyCheck.java",
        new DevonArchitectureComponentDependencyCheck());
  }

}
