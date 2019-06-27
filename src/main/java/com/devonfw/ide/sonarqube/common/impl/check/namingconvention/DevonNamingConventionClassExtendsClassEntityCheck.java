package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E8", name = "Devon naming conventions of inheriting classes (Entity).", //
    description = "Classes extending ApplicationPersistenceEntity shall end with Entity. In addition, classes "
        + " that inherit from a class with the suffix Entity must also have Entity as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })

public class DevonNamingConventionClassExtendsClassEntityCheck extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassEntityCheck() {

    super("ApplicationPersistenceEntity", "Entity$");
  }

}
