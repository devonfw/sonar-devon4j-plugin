package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending AbstractEto are following the
 * devonfw naming convention by ending with Eto.
 */
@Rule(key = "Devon4j:E9", name = "Devon naming conventions of inheriting classes (Eto).", //
    description = "Verify that Classes extending AbstractEto shall end with Eto. In addition, classes "
        + " that inherit from a class with the suffix Eto must also have Eto as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassEtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Eto classes.
   */
  public DevonNamingConventionClassExtendsClassEtoCheck() {

    super("AbstractEto", "Eto$");
  }

}
