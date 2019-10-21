package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending ApplicationPersistenceEntity are
 * following the devonfw naming convention by ending with Entity.
 */
@Rule(key = "N3")
public class DevonNamingConventionClassExtendsClassEntityCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Entity classes.
   */
  public DevonNamingConventionClassExtendsClassEntityCheck() {

    super(".*Entity");
  }

}
