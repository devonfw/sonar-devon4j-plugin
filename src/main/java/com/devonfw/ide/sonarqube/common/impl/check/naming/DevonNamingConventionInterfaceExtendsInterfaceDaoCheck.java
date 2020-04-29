package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that interfaces extending Dao are following the devonfw
 * naming convention by ending with Dao.
 */
@Rule(key = "N8", name = "devonfw Naming Check of DAO Interfaces", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionInterfaceExtendsInterfaceDaoCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Dao interfaces.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceDaoCheck() {

    super(".*Dao");
  }

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

}
