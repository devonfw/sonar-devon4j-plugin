package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending AbstractCto are following the
 * devonfw naming convention by ending with Cto.
 */
@Rule(key = "N1")
public class DevonNamingConventionClassExtendsClassCtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Cto classes.
   */
  public DevonNamingConventionClassExtendsClassCtoCheck() {

    super(".*Cto");
  }

}
