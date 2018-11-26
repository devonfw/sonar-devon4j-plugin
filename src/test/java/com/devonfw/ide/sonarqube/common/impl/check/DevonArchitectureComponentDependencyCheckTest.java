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

    DevonArchitectureComponentDependencyCheck check = new DevonArchitectureComponentDependencyCheck();
    JavaCheckVerifier.verify("src/test/files/DevonArchitectureComponentDependencyCheck.java", check);
  }

  /**
   * Test of {@link DevonArchitectureComponentDependencyCheck}.
   */
  @Test
  public void test2() {

    DevonArchitectureComponentDependencyCheck check = new DevonArchitectureComponentDependencyCheck();
    JavaCheckVerifier.verify("src/test/files/DevonArchitectureComponentDependencyCheck2.java", check);
  }

}
