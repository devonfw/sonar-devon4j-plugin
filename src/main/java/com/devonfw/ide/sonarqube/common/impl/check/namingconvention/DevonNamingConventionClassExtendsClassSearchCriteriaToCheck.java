package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E11", name = "Devon Naming Convention Check", //
    description = "Verify that Classes extending AbstractSearchCriteriaTo shall end with SearchCriteriaTo.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassSearchCriteriaToCheck
    extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassSearchCriteriaToCheck() {

    super("AbstractSearchCriteriaTo", "SearchCriteriaTo$");
  }

}
