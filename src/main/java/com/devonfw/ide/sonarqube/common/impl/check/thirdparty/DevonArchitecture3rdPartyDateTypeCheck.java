package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyCheck;
import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that proper date types are used.
 */
@Rule(key = "E7", name = "devonfw 3rd Party Date Type Check", //
    priority = Priority.MINOR, tags = { "architecture-violation", "devonfw", "thirdparty" })
public class DevonArchitecture3rdPartyDateTypeCheck extends DevonArchitecture3rdPartyCheck {

    @Override protected String checkDependency(JavaType source, JavaType target) {

        String targetString = target.toString();

        if (targetString.equals("java.util.Date")) {
            return "Use the java.time.LocalDate[Time] instead";
        }
        if (targetString.equals("java.util.Calendar")) {
            return "Use java.time.LocalDate[Time], java.time.ZonedDateTime or java.time.OffsetDateTime instead";
        }
        if (targetString.equals("java.sql.Date")) {
            return "Use java.time.LocalDate instead";
        }
        if (targetString.equals("java.sql.Timestamp")) {
            return "Use java.time.Instant instead";
        }
        return null;
    }
}
