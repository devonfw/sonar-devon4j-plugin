package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that classes extending AbstractEto are following the
 * devonfw naming convention by ending with Eto.
 */
@Rule(key = "N4", name = "devonfw Naming Check of Eto Classes", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionClassExtendsClassEtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on Eto classes.
   */
  public DevonNamingConventionClassExtendsClassEtoCheck() {

    super(".*Eto");
  }

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

}
