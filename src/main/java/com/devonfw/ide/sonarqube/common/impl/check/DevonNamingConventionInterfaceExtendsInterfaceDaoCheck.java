package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * @author vhacimuf
 *
 */

@Rule(key = "Devon4j:S2", name = "Devon Naming Convention Check", //
    description = "Verify that Interfaces extending Dao shall end with Dao", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionInterfaceExtendsInterfaceDaoCheck
    extends DevonNamingConventionInterfaceExtendsInterfaceCheck {

  @Override
  public void init() {

    this.extendedInterface = "Dao";
    this.extendingInterfaceSuffix = "Dao$";
  }

}
