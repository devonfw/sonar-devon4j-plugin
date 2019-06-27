package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E12", name = "Devon Naming Convention Check", //
    description = "Classes extending AbstractTo but neither AbstractEto nor AbstractCto shall end with To.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })

public class DevonNamingConventionClassExtendsClassToCheck extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassToCheck() {

    super("AbstractTo", "[^CEce]To$");
  }

}
