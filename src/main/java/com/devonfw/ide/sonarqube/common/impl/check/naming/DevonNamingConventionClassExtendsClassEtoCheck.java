package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending AbstractEto are following the
 * devonfw naming convention by ending with Eto.
 */
@Rule(key = "Devon4j:N4", name = "Devon naming conventions of inheriting classes (Eto).", //
    description = "Verify that Classes extending AbstractEto shall end with Eto. In addition, classes "
        + " that inherit from a class with the suffix Eto must also have Eto as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionClassExtendsClassEtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Eto classes.
   */
  public DevonNamingConventionClassExtendsClassEtoCheck() {

    super(".*Eto");
  }

}
