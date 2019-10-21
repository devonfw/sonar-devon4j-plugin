package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyCheck;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that {@link java.util.Objects} from JDK is used (rather than
 * proprietary versions from Guava, etc.).
 */
@Rule(key = "E5")
public class DevonArchitecture3rdPartyObjectsCheck extends DevonArchitecture3rdPartyCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (target.toString().equals("com.google.common.base.Objects")) {
      return "Use Java standards instead (java.util.Objects).";
    }
    return null;
  }

}
