package com.devonfw.ide.sonarqube.common.impl.check;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeBase2Base4ComponentPartCheck}.
 */
public class DevonArchitectureScopeBase2Base4ComponentPartCheckTest {

  /**
   * Test of {@link DevonArchitectureScopeBase2Base4ComponentPartCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureScopeBase2Base4ComponentPartCheck.java",
        new DevonArchitectureScopeBase2Base4ComponentPartCheck());
  }

}
