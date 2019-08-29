package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending AbstractSearchCriteriaTo are
 * following the devonfw naming convention by ending with SearchCriteriaTo.
 */
@Rule(key = "Devon4j:E11", name = "Devon naming convention of inheriting classes (SearchCriteriaTo)", //
    description = "Verify that Classes extending AbstractSearchCriteriaTo shall end with SearchCriteriaTo. "
        + "In addition, classes that inherit from a class with the suffix SearchCriteriaTo must also "
        + "have SearchCriteriaTo as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassSearchCriteriaToCheck
    extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on SearchCriteriaTo classes.
   */
  public DevonNamingConventionClassExtendsClassSearchCriteriaToCheck() {

    super("AbstractSearchCriteriaTo", "SearchCriteriaTo$");
  }

}
