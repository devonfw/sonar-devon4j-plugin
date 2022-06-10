package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionCheck} verifying that classes extending AbstractEto are following the devonfw naming
 * convention by ending with Eto.
 */
@Rule(key = "N4", name = "devonfw Naming Check of Eto Types", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionEtoCheck extends DevonNamingConventionCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Eto classes.
   */
  public DevonNamingConventionEtoCheck() {

    super(".*Eto");
  }

}
