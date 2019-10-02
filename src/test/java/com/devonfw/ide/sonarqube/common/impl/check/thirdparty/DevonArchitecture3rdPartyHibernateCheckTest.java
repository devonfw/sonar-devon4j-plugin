package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyHibernateCheck}.
 */
public class DevonArchitecture3rdPartyHibernateCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyHibernateCheck}.
   */
  @Test
  public void testApi() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyHibernateCheck_Api.java",
        new DevonArchitecture3rdPartyHibernateCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyHibernateCheck}.
   */
  @Test
  public void testNonDataAccess() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyHibernateCheck_NonDataaccess.java",
        new DevonArchitecture3rdPartyHibernateCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyHibernateCheck}.
   */
  @Test
  public void testOK() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/thirdparty/DevonArchitecture3rdPartyHibernateCheck_OK.java",
        new DevonArchitecture3rdPartyHibernateCheck());
  }

}
