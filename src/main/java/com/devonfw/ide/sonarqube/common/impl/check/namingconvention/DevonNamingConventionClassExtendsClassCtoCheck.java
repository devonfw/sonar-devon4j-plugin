package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E6", name = "Devon Naming Convention Check", //
    description = "Verify that Classes extending AbstractCto shall end with Cto.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassCtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * The constructor.
   */
  public DevonNamingConventionClassExtendsClassCtoCheck() {

    super("AbstractCto", "Cto$");
  }

}
