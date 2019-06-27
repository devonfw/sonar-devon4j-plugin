package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E12", name = "Devon naming convention of inheriting interfaces (Dao)", //
    description = "Verify that Interfaces extending Dao shall end with Dao.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })

public class DevonNamingConventionInterfaceExtendsInterfaceDaoCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  public DevonNamingConventionInterfaceExtendsInterfaceDaoCheck() {

    super("Dao", "Dao$");
  }

}
