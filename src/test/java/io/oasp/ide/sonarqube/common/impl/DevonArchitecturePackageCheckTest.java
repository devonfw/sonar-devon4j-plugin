package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecturePackageCheck}.
 */
public class DevonArchitecturePackageCheckTest {

  /**
   * Test the {@link DevonArchitecturePackageCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitecturePackageCheck.java", new DevonArchitecturePackageCheck());
  }

}