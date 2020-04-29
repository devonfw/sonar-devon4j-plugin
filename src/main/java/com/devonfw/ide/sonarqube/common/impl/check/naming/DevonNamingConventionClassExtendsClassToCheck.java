package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes directly extending AbstractTo are
 * following the devonfw naming convention by ending with To.
 */
@Rule(key = "N7", name = "devonfw Naming Check of Transfer Object Classes", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionClassExtendsClassToCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on To classes.
   */
  public DevonNamingConventionClassExtendsClassToCheck() {

    super(".*To");
  }

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

}
