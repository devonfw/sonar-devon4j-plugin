package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerServiceDataaccessCheck;

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
