package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 *
 */
@Rule(key = "DevonArchitecturePackageCheck", name = "Devon Package Check", description = "Verify that the code is following the devon package conventions.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitecturePackageCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    return null;
  }

  @Override
  protected String createIssueForInvalidSourcePackage(OaspPackage pkg) {

    return "The package '" + pkg.toString() + " is not a valid OASP package.";
  }

}
