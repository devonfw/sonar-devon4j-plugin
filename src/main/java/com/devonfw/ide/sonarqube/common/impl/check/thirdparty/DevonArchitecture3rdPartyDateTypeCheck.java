package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyCheck;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that proper date types are used.
 */
@Rule(key = "E7", name = "devonfw 3rd Party Date Type Check", //
    priority = Priority.MINOR, tags = { "architecture-violation", "devonfw", "thirdparty" })
public class DevonArchitecture3rdPartyDateTypeCheck extends DevonArchitecture3rdPartyCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    String targetFqn = target.getQualifiedName();

    if (targetFqn.equals("java.util.Date")) {
      return "Use java.time.LocalDate[Time] instead";
    } else if (targetFqn.equals("java.util.Calendar")) {
      return "Use java.time.LocalDate[Time], java.time.ZonedDateTime or java.time.OffsetDateTime instead";
    } else if (targetFqn.equals("java.sql.Date")) {
      return "Use java.time.LocalDate instead";
    } else if (targetFqn.equals("java.sql.Timestamp")) {
      return "Use java.time.Instant instead";
    }
    return null;
  }
}
