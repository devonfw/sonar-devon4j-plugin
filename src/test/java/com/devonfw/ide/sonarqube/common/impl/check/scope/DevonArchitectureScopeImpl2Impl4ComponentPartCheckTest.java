package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitectureScopeImpl2Impl4ComponentPartCheck}.
 */
public class DevonArchitectureScopeImpl2Impl4ComponentPartCheckTest {

  /**
   * Test the {@link DevonArchitectureScopeImpl2Impl4ComponentPartCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/scope/DevonArchitectureScopeImpl2Impl4ComponentPartCheck.java",
        new DevonArchitectureScopeImpl2Impl4ComponentPartCheck());
  }

}