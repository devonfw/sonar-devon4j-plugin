package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyTransactionalCheck}.
 */
public class DevonArchitecture3rdPartyTransactionalCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyTransactionalCheck}.
   */
  @Test
  public void test() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyTransactionalCheck.java",
        new DevonArchitecture3rdPartyTransactionalCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyTransactionalCheck}.
   */
  @Test
  public void testApi() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyTransactionalCheck_Api.java",
        new DevonArchitecture3rdPartyTransactionalCheck());
  }

}
