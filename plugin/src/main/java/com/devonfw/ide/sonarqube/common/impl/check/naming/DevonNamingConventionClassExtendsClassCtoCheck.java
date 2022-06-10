package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending AbstractCto are following the
 * devonfw naming convention by ending with Cto.
 */
@Rule(key = "N1", name = "devonfw Naming Check of Cto Classes", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionClassExtendsClassCtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Cto classes.
   */
  public DevonNamingConventionClassExtendsClassCtoCheck() {

    super(".*Cto");
  }

}
