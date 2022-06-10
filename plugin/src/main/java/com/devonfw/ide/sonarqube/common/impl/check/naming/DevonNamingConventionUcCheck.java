package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionCheck} verifying that non-abstract classes inherited from AbstractUc are following the
 * devonfw naming convention by beginning with Uc and ending with Impl. They must also implement an interface with the
 * same name except for the suffix Impl.
 */
@Rule(key = "N5", name = "devonfw Naming Check of Use-Case Types", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionUcCheck extends DevonNamingConventionCheck {

  /**
   * Calls super constructor to compile the pattern classSuffixRegEx with Uc.*Impl.
   */
  public DevonNamingConventionUcCheck() {

    super(".*Uc|Uc.*", "Uc.*Impl");
  }

  @Override
  protected String getIssueMessageForMissingInterface(String interfaceName) {

    return "Use-case implementation should implement according interface (" + interfaceName + ").";
  }

}
