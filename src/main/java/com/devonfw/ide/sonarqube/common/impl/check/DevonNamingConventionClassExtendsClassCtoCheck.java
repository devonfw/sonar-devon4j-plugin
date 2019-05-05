package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * @author vhacimuf
 *
 */

@Rule(key = "Devon4j:S2", name = "Devon Naming Convention Check", //
    description = "Verify that Classes extending AbstractCto shall end with Cto.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassCtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  @Override
  public void init() {

    this.extendedSuperClass = "AbstractCto";
    this.classSuffixRegEx = "Cto$";
  }

}
