package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E13", name = "Devon naming convention of inheriting interfaces (Repository)", //
    description = "Verify that Interfaces extending DefaultRepository shall end with Repository. In addition, "
        + "interfaces that inherit from a interface with the suffix Repository must also have Repository as their suffix", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  public DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck() {

    super("DefaultRepository", "Repository$");
  }

}
