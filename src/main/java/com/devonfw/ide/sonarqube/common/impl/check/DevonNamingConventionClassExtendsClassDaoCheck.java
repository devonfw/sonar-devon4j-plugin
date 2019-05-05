package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:S2", name = "Devon Naming Convention Check", //
    description = "Verify that Non-Abstract Classes extending AbstractDao shall end with DaoImpl.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassDaoCheck extends DevonNamingConventionClassExtendsClassCheck {

  @Override
  public void init() {

    this.extendedSuperClass = "AbstractDao";
    this.classSuffixRegEx = "DaoImpl$";
    this.isAbstract = false;
  }

}
