package com.devonfw.ide.sonarqube.common.impl.check;

/**
 * @author ssabah
 *
 */

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerDataaccessLogicCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureLayerDataaccessServiceCheck;

/**
 * Test of {@link DevonArchitectureLayerDataaccessLogicCheck}.
 */

public class DevonArchitectureLayerDataaccessServiceCheckTest {

  /**
   * Test the {@link DevonArchitectureLayerDataaccessServiceCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerDataaccessServiceCheck.java",
        new DevonArchitectureLayerDataaccessServiceCheck());
  }

}
