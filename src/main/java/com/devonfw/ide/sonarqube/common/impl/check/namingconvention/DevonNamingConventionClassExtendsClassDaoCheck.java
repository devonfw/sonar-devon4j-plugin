package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E7", name = "Devon Naming Convention Check", //
    description = "Verify that Non-Abstract Classes extending AbstractDao shall end with DaoImpl.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassDaoCheck extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassDaoCheck() {

    super("AbstractDao", "DaoImpl$", false);
  }
}
