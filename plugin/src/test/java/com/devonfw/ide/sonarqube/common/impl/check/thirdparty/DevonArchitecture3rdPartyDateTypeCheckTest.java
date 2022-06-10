package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test of {@link DevonArchitecture3rdPartyDateTypeCheck}.
 */
public class DevonArchitecture3rdPartyDateTypeCheckTest {

  /**
   * Test of {@link DevonArchitecture3rdPartyDateTypeCheck} verifies that the use of discouraged date types annotations
   * 'java.util.Date' is not allowed.
   */
  @Test
  public void testJavaUtilDate() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyDateTypeCheck_JavaUtilDate.java",
        new DevonArchitecture3rdPartyDateTypeCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyDateTypeCheck} verifies that the use of correct date types annotations
   * 'java.time.LocalDate' is not flagged.
   */
  @Test
  public void testJavaTimeLocalDate() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyDateTypeCheck_JavaTimeLocalDate.java",
        new DevonArchitecture3rdPartyDateTypeCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyDateTypeCheck} verifies that the use of correct date types annotations
   * 'java.time.LocalDateTime' is not flagged.
   */
  @Test
  public void testJavaTimeLocalDateTime() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyDateTypeCheck_JavaTimeLocalDateTime.java",
        new DevonArchitecture3rdPartyDateTypeCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyDateTypeCheck} verifies that the use of discouraged date types annotations
   * 'java.util.Calendar' is not allowed.
   */
  @Test
  public void testJavaUtilCalendar() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyDateTypeCheck_JavaUtilCalendar.java",
        new DevonArchitecture3rdPartyDateTypeCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyDateTypeCheck} verifies that the use of correct date types annotations
   * 'java.time.ZonedDateTime' is not flagged.
   */
  @Test
  public void testJavaTimeZonedDateTime() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyDateTypeCheck_JavaTimeZonedDateTime.java",
        new DevonArchitecture3rdPartyDateTypeCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyDateTypeCheck} verifies that the use of correct date types annotations
   * 'java.time.OffsetDateTime' is not flagged.
   */
  @Test
  public void testJavaTimeOffsetDateTime() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyDateTypeCheck_JavaTimeOffsetDateTime.java",
        new DevonArchitecture3rdPartyDateTypeCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyDateTypeCheck} verifies that the use of discouraged date types annotations
   * 'java.sql.Date' is not allowed.
   */
  @Test
  public void testJavaSqlDate() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyDateTypeCheck_JavaSqlDate.java",
        new DevonArchitecture3rdPartyDateTypeCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyDateTypeCheck} verifies that the use of discouraged date types annotations
   * 'java.sql.Timestamp' is not allowed.
   */
  @Test
  public void testJavaSqlTimestamp() {

    JavaCheckVerifier.verify("src/test/files/thirdparty/DevonArchitecture3rdPartyDateTypeCheck_JavaSqlTimestamp.java",
        new DevonArchitecture3rdPartyDateTypeCheck());
  }

  /**
   * Test of {@link DevonArchitecture3rdPartyDateTypeCheck} verifies that the use of correct date types annotations
   * 'java.time.Instant' is not flagged.
   */
  @Test
  public void testJavaTimeInstant() {

    JavaCheckVerifier.verifyNoIssue(
        "src/test/files/thirdparty/DevonArchitecture3rdPartyDateTypeCheck_JavaTimeInstant.java",
        new DevonArchitecture3rdPartyDateTypeCheck());
  }
}
