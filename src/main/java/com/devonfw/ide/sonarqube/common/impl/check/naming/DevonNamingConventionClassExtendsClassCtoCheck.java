package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending AbstractCto are following the
 * devonfw naming convention by ending with Cto.
 */
@Rule(key = "Devon4j:N1", name = "Devon naming convention of inheriting classes (AbstractCto)", //
    description = "Verify that Classes extending AbstractCto shall end with Cto. In addition, classes "
        + "that inherit from a class with the suffix Cto must also have Cto as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionClassExtendsClassCtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Cto classes.
   */
  public DevonNamingConventionClassExtendsClassCtoCheck() {

    super(".*Cto");
  }

}
