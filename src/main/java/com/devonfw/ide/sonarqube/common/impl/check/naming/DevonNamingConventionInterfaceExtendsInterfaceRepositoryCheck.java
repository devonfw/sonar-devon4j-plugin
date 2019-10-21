package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that interfaces extending DefaultRepository are
 * following the devonfw naming convention by ending with Repository.
 */
@Rule(key = "N9")
public class DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on repository interfaces.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceRepositoryCheck() {

    super(".*Repository");
  }

}
