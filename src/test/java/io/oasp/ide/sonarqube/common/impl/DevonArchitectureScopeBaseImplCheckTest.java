package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author ssabah
 *
 */

// DevonArchitectureScopeBaseImplCheck

public class DevonArchitectureScopeBaseImplCheckTest {

  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeBaseImplCheck.java",
        new DevonArchitectureScopeBaseImplCheck());
  }

}
