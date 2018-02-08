package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author ssabah
 *
 */
/**
 * Test the {@link DevonArchitectureLayerServiceDataaccessCheck}.
 */

public class DevonArchitectureLayerServiceDataaccessCheckTest {

  /**
   *
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerServiceDataaccessCheck.java",
        new DevonArchitectureLayerServiceDataaccessCheck());
  }

}
