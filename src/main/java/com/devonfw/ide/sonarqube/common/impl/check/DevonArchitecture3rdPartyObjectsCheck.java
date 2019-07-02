package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that {@link java.util.Objects} from JDK is used (rather than
 * proprietary versions from Guava, etc.).
 */
@Rule(key = "Devon4j:E5", name = "Devon 3rd Party Objects Check", //
    description = "Verify that Objects is used from JDK.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonArchitecture3rdPartyObjectsCheck extends DevonArchitecture3rdPartyCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (target.toString().equals("com.google.common.base.Objects")) {
      return "Use Java standards instead (java.util.Objects).";
    }
    return null;
  }

}
