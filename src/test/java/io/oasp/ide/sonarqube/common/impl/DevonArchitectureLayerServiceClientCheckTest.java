package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author ssabah
 *
 */
public class DevonArchitectureLayerServiceClientCheckTest {

  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerServiceClientCheck.java",
        new DevonArchitectureLayerServiceClientCheck());
  }

}
