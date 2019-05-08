package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E12", name = "Devon Naming Convention Check", //
    description = "Verify that Interfaces extending Dao shall end with Dao", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionInterfaceExtendsInterfaceDaoCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  /**
   * The constructor.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceDaoCheck() {

    super("Dao", "Dao$");
  }

}
