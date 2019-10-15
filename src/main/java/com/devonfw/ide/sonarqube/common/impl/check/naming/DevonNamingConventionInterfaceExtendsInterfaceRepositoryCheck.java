package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that interfaces extending DefaultRepository are
 * following the devonfw naming convention by ending with Repository.
 */
@Rule(key = "Devon4j:N9", name = "Devon naming convention of inheriting interfaces (Repository)", //
    description = "Verify that Interfaces extending DefaultRepository shall end with Repository. In addition, "
        + "interfaces that inherit from an interface with the suffix Repository must also have Repository as their suffix", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on repository interfaces.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck() {

    super(".*Repository");
  }

}
