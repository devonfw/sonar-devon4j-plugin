package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionCheck} verifying that classes extending AbstractSearchCriteriaTo are following the
 * devonfw naming convention by ending with SearchCriteriaTo.
 */
@Rule(key = "N6", name = "devonfw Naming Check of SearchCriteriaTo Types", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionSearchCriteriaToCheck extends DevonNamingConventionCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on SearchCriteriaTo classes.
   */
  public DevonNamingConventionSearchCriteriaToCheck() {

    super(".*SearchCriteriaTo");
  }

}
