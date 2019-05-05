package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:S2", name = "Devon Naming Convention Check", //
    description = "Classes extending AbstractTo but neither AbstractEto nor AbstractCto shall end with To.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassToCheck extends DevonNamingConventionClassExtendsClassCheck {

  @Override
  public void init() {

    this.extendedSuperClass = "AbstractTo";
    this.classSuffixRegEx = "[^CEce]To$";
  }

}
