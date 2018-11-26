package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerClientDataaccessCheck;

/**
 * Test of {@link DevonArchitectureLayerClientDataaccessCheck}.
 */
public class DevonArchitectureLayerClientDataaccessCheckTest {

  /**
   * Test of {@link DevonArchitectureLayerClientDataaccessCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerClientDataaccessCheck.java",
        new DevonArchitectureLayerClientDataaccessCheck());
  }

}
