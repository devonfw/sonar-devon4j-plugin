package com.devonfw.ide.sonarqube.common.impl.check;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * Super class for checks that need to make use of doScanFile()
 */
public abstract class DevonArchitectureCodeCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

}
