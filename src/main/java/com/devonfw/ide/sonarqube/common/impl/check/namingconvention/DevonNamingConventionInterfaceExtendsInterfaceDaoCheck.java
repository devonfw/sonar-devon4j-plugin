package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that interfaces extending Dao are following the devonfw
 * naming convention by ending with Dao.
 */
@Rule(key = "Devon4j:E12", name = "Devon naming convention of inheriting interfaces (Dao)", //
    description = "Verify that Interfaces extending Dao shall end with Dao.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionInterfaceExtendsInterfaceDaoCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Dao interfaces.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceDaoCheck() {

    super("Dao", "Dao$");
  }

}
