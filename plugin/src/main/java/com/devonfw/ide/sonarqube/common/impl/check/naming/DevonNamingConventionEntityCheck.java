package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionCheck} verifying that classes extending ApplicationPersistenceEntity are following the
 * devonfw naming convention by ending with Entity.
 */
@Rule(key = "N3", name = "devonfw Naming Check of Entity Types", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionEntityCheck extends DevonNamingConventionCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Entity classes.
   */
  public DevonNamingConventionEntityCheck() {

    super(".*Entity");
  }

}
