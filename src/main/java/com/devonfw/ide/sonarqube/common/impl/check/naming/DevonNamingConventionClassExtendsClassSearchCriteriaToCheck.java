package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending AbstractSearchCriteriaTo are
 * following the devonfw naming convention by ending with SearchCriteriaTo.
 */
@Rule(key = "N6", name = "Devon Naming Check of SearchCriteriaTo Classes", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionClassExtendsClassSearchCriteriaToCheck
    extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on SearchCriteriaTo classes.
   */
  public DevonNamingConventionClassExtendsClassSearchCriteriaToCheck() {

    super(".*SearchCriteriaTo");
  }

}
