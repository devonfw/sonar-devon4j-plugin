package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecturePackageCheck;

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

  /**
   * Test the {@link DevonArchitecturePackageCheck}.
   */
  @Test
  public void test2() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/DevonArchitecturePackageCheck2.java",
        new DevonArchitecturePackageCheck());
  }

}