package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeBase2Impl4ComponentPartCheck}.
 */
public class DevonArchitectureScopeBase2Impl4ComponentPartCheckTest {

  /**
   * Test of {@link DevonArchitectureScopeBase2Impl4ComponentPartCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/scope/DevonArchitectureScopeBase2Impl4ComponentPartCheck.java",
        new DevonArchitectureScopeBase2Impl4ComponentPartCheck());
  }

}
