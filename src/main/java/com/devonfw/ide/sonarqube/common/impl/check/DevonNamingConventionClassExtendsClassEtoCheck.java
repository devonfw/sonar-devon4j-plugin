package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * @author vhacimuf
 *
 */

@Rule(key = "Devon4j:S2", name = "Devon Naming Convention Check", //
    description = "Verify that Classes extending AbstractEto shall end with Eto.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassEtoCheck extends DevonNamingConventionClassExtendsClassCheck {

  @Override
  public void init() {

    this.extendedSuperClass = "AbstractEto";
    this.classSuffixRegEx = "Eto$";
  }

}
