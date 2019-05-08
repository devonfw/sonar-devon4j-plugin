package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E9", name = "Devon Naming Convention Check", //
    description = "Verify that Classes extending AbstractEto shall end with Eto.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassEtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassEtoCheck() {

    super("AbstractEto", "Eto$");
  }

}
