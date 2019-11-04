package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeApi2Base4ComponentPartCheck}.
 */
public class DevonArchitectureScopeApi2Base4ComponentPartCheckTest {

  /**
   * Test of {@link DevonArchitectureScopeApi2Base4ComponentPartCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/scope/DevonArchitectureScopeApi2Base4ComponentPartCheck.java",
        new DevonArchitectureScopeApi2Base4ComponentPartCheck());
  }

}
