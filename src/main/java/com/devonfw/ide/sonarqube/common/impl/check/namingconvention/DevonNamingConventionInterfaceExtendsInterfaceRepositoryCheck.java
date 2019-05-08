package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E13", name = "Devon Naming Convention Check", //
    description = "Verify that Interfaces extending DefaultRepository shall end with Repository", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  /**
   * The constructor.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck() {

    super("DefaultRepository", "Repository$");
  }

}
