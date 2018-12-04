package com.devonfw.ide.sonarqube.common.impl.check;

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

    JavaCheckVerifier.verify("src/test/files/DevonArchitecture3rdPartyTransactionalCheck.java",
        new DevonArchitecture3rdPartyTransactionalCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyTransactionalCheck}.
   */
  @Test
  public void testApi() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitecture3rdPartyTransactionalCheckApi.java",
        new DevonArchitecture3rdPartyTransactionalCheck());
  }

}
