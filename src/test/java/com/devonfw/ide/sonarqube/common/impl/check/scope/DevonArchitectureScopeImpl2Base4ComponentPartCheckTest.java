package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeImpl2Base4ComponentPartCheck}.
 */
public class DevonArchitectureScopeImpl2Base4ComponentPartCheckTest {

  /**
   * Test of {@link DevonArchitectureScopeImpl2Base4ComponentPartCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeImpl2Base4ComponentPartCheck.java",
        new DevonArchitectureScopeImpl2Base4ComponentPartCheck());
  }

}
