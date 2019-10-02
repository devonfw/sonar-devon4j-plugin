package com.devonfw.ide.sonarqube.common.impl.check.packaging;

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
  public void testNoScope() {

    JavaCheckVerifier.verify("src/test/files/packaging/DevonArchitecturePackageCheck_NoScope.java",
        new DevonArchitecturePackageCheck());
  }

  /**
   * Test the {@link DevonArchitecturePackageCheck}.
   */
  @Test
  public void testIllegalLayer() {

    JavaCheckVerifier.verify("src/test/files/packaging/DevonArchitecturePackageCheck_IllegalLayer.java",
        new DevonArchitecturePackageCheck());
  }

  /**
   * Test the {@link DevonArchitecturePackageCheck}.
   */
  @Test
  public void testIllegalRoot() {

    JavaCheckVerifier.verify("src/test/files/packaging/DevonArchitecturePackageCheck_IllegalRoot.java",
        new DevonArchitecturePackageCheck());
  }

  /**
   * Test the {@link DevonArchitecturePackageCheck}.
   */
  @Test
  public void testNoIssue() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/packaging/DevonArchitecturePackageCheck_OK.java",
        new DevonArchitecturePackageCheck());
  }

  /**
   * Test the {@link DevonArchitecturePackageCheck}.
   */
  @Test
  public void testNoIssueSpringBootApp() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/packaging/DevonArchitecturePackageCheck_OK_SpringBootApp.java",
        new DevonArchitecturePackageCheck());
  }

}