package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionCheck} verifying that non-abstract classes extending AbstractDao are following the
 * devonfw naming convention by ending with DaoImpl.
 */
@Rule(key = "N2", name = "devonfw Naming Check of DAO Types", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionDaoCheck extends DevonNamingConventionCheck {

  /**
   * Calls super constructor to compile the pattern classSuffiRegEx
   */
  public DevonNamingConventionDaoCheck() {

    super(".*Dao(Impl)?", ".*DaoImpl");
  }

  @Override
  protected String getIssueMessageForMissingInterface(String interfaceName) {

    return "DAO implementation should implement according interface (" + interfaceName + ").";
  }

}
