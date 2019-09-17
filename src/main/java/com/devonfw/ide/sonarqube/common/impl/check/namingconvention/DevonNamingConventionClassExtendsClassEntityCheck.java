package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending ApplicationPersistenceEntity are
 * following the devonfw naming convention by ending with Entity.
 */
@Rule(key = "Devon4j:N3", name = "Devon naming conventions of inheriting classes (Entity).", //
    description = "Classes extending ApplicationPersistenceEntity shall end with Entity. In addition, classes "
        + " that inherit from a class with the suffix Entity must also have Entity as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassEntityCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Entity classes.
   */
  public DevonNamingConventionClassExtendsClassEntityCheck() {

    super(".*Entity");
  }

}
