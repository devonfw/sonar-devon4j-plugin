package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyCheck;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that QueryDSL is used properly rather than legacy Mysema API.
 */
@Rule(key = "E2")
public class DevonArchitecture3rdPartyMysemaCheck extends DevonArchitecture3rdPartyCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (target.getPackage().startsWith("com.mysema.query")) {
      return "Use official QueryDSL (com.querydsl.* e.g. from com.querydsl:querydsl-jpa).";
    }
    return null;
  }

}
