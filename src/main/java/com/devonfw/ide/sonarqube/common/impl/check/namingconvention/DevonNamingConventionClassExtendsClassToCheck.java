package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes directly extending AbstractTo are
 * following the devonfw naming convention by ending with To.
 */
@Rule(key = "Devon4j:E12", name = "Devon Naming Convention Check", //
    description = "Classes extending AbstractTo but neither AbstractEto nor AbstractCto shall end with To.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassToCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on To classes.
   */
  public DevonNamingConventionClassExtendsClassToCheck() {

    super("AbstractTo", "[^CEce]To$");
  }

}
