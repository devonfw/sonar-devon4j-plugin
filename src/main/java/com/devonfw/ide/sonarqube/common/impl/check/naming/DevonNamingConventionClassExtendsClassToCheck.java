package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes directly extending AbstractTo are
 * following the devonfw naming convention by ending with To.
 */
@Rule(key = "Devon4j:N7", name = "Devon Naming Convention Check", //
    description = "Classes extending AbstractTo but neither AbstractEto nor AbstractCto shall end with To.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassToCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on To classes.
   */
  public DevonNamingConventionClassExtendsClassToCheck() {

    super(".*To");
  }

}
