package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyImmutableCheck}.
 */
public class DevonArchitecture3rdPartyImmutableCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyImmutableCheck} verifies that the use of Immutable from javax package in
   * Entity class is not allowed.
   */
  @Test
  public void testNotOKJavaxImmutableEntityClass() {

    JavaCheckVerifier.verify(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyImmutableCheck_JavaxImmutableEntityClass.java",
        new DevonArchitecture3rdPartyImmutableCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyImmutableCheck} verifies that the use of Immutable from javax package in
   * other class is allowed.
   */
  @Test
  public void testOKJavaxImmutableNonEntityClass() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyImmutableCheck_JavaxImmutableNonEntityClass.java",
        new DevonArchitecture3rdPartyImmutableCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyImmutableCheck} verifies that Immutable is used from proper package in
   * Entity class.
   */
  @Test
  public void testOK() {

    JavaCheckVerifier.verifyNoIssue("src/test/files/thirdparty/DevonArchitecture3rdPartyImmutableCheck_OK.java",
        new DevonArchitecture3rdPartyImmutableCheck());
  }
}