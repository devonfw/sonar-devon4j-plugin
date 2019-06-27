package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E9", name = "Devon naming conventions of inheriting classes (Eto).", //
    description = "Verify that Classes extending AbstractEto shall end with Eto. In addition, classes "
        + " that inherit from a class with the suffix Eto must also have Eto as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })

public class DevonNamingConventionClassExtendsClassEtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassEtoCheck() {

    super("AbstractEto", "Eto$");
  }

}
