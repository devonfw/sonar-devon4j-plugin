package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:S2", name = "Devon Naming Convention Check", //
    description = "Verify that Classes extending AbstractSearchCriteriaTo shall end with SearchCriteriaTo.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassSearchCriteriaToCheck
    extends DevonNamingConventionClassExtendsClassCheck {

  @Override
  public void init() {

    this.extendedSuperClass = "AbstractSearchCriteriaTo ";
    this.classSuffixRegEx = "SearchCriteriaTo$";
  }

}
