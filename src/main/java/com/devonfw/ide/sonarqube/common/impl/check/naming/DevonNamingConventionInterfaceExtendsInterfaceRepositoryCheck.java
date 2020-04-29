package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that interfaces extending DefaultRepository are
 * following the devonfw naming convention by ending with Repository.
 */
@Rule(key = "N9", name = "devonfw Naming Check of Repository Interfaces", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on repository interfaces.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck() {

    super(".*Repository");
  }

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

}
