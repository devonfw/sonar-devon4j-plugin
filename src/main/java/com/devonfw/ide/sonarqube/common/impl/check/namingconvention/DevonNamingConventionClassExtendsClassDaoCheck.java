package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E7", name = "Devon naming conventions of inheriting classes (DaoImpl).", //
    description = "Verify that non-abstract Classes extending AbstractDao shall end with DaoImpl. In addition, classes "
        + "that inherit from a class with the suffix DaoImpl must also have DaoImpl as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })

public class DevonNamingConventionClassExtendsClassDaoCheck extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassDaoCheck() {

    super("AbstractDao", "DaoImpl$", false);
  }
}
