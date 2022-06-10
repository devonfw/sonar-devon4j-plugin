package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyHibernateCheck}.
 */
public class DevonArchitecture3rdPartyHibernateCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyHibernateCheck} verifies that the use of Hibernate is not allowed outside
   * of the dataaccess layer.
   */
  @Test
  public void testNonDataAccess() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyHibernateCheck_NonDataaccess.java",
        new DevonArchitecture3rdPartyHibernateCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyHibernateCheck} verifies that the use of discouraged Hibernate annotations
   * is not allowed.
   */
  @Test
  public void testDiscouragedAnnotations() {

    JavaCheckVerifier.verify(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyHibernateCheck_DiscouragedAnnotations.java",
        new DevonArchitecture3rdPartyHibernateCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyHibernateCheck} verifies that the use of Hibernate envers is not allowed
   * outside of the impl scope of the dataaccess layer.
   */
  @Test
  public void testEnversNotInImplScope() {

    JavaCheckVerifier.verify(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyHibernateCheck_EnversNotInImplScope.java",
        new DevonArchitecture3rdPartyHibernateCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyHibernateCheck} verifies that the direct use of Hibernate envers internals
   * is not allowed.
   */
  @Test
  public void testUsingHibernateEnversDirectly() {

    JavaCheckVerifier.verify(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyHibernateCheck_UsingHibernateEnversDirectly.java",
        new DevonArchitecture3rdPartyHibernateCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyHibernateCheck} verifies that the use of Hibernate outside of the impl
   * scope of the dataaccess layer is not allowed.
   */
  @Test
  public void testApi() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyHibernateCheck_Api.java",
        new DevonArchitecture3rdPartyHibernateCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyHibernateCheck} verifies that the correct use of Hibernate is not flagged.
   */
  @Test
  public void testOK() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/thirdparty/DevonArchitecture3rdPartyHibernateCheck_OK.java",
        new DevonArchitecture3rdPartyHibernateCheck());
  }

}
