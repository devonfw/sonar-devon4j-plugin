package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E6", name = "Devon naming convention of inheriting classes (AbstractCto)", //
    description = "Verify that Classes extending AbstractCto shall end with Cto. In addition, classes "
        + "that inherit from a class with the suffix Cto must also have Cto as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })

public class DevonNamingConventionClassExtendsClassCtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassCtoCheck() {

    super("AbstractCto", "Cto$");
  }

}
