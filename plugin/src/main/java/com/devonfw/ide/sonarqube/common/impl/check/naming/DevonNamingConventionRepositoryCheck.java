package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionCheck} verifying that interfaces extending DefaultRepository are following the devonfw
 * naming convention by ending with Repository.
 */
@Rule(key = "N9", name = "devonfw Naming Check of Repository Types", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionRepositoryCheck extends DevonNamingConventionCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on repository interfaces.
   */
  public DevonNamingConventionRepositoryCheck() {

    super(".*Repository");
  }

}
