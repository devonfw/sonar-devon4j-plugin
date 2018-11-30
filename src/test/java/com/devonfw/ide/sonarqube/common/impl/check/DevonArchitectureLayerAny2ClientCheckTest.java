package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureLayerAny2ClientCheck}.
 */
public class DevonArchitectureLayerAny2ClientCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerAny2ClientCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerAny2ClientCheck.java",
        new DevonArchitectureLayerAny2ClientCheck());
  }

}
