package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionCheck} verifying that classes directly extending AbstractTo are following the devonfw
 * naming convention by ending with To.
 */
@Rule(key = "N7", name = "devonfw Naming Check of Transfer Object Types", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionToCheck extends DevonNamingConventionCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on To classes.
   */
  public DevonNamingConventionToCheck() {

    super(".*To");
  }

}
