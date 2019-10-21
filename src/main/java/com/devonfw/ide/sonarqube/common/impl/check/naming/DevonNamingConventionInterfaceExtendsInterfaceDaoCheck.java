package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that interfaces extending Dao are following the devonfw
 * naming convention by ending with Dao.
 */
@Rule(key = "N8")
public class DevonNamingConventionInterfaceExtendsInterfaceDaoCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Dao interfaces.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceDaoCheck() {

    super(".*Dao");
  }

}
