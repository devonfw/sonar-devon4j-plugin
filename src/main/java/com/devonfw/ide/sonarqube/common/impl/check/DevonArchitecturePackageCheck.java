package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying the devon package conventions.
 */
@Rule(key = "DevonArchitecturePackageCheck", name = "Devon Package Check", description = "Verify the devon package conventions.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitecturePackageCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    return null;
  }

  @Override
  protected String createIssueForInvalidSourcePackage(Devon4jPackage pkg) {

    if (pkg.isValid()) {
      return null;
    }
    StringBuilder sb = new StringBuilder(64);
    sb.append("The package '");
    sb.append(pkg.toString());
    sb.append("' is not compliant with your architecture.");
    if (!pkg.isValidLayer()) {
      sb.append(" Layer '");
      sb.append(pkg.getLayer());
      sb.append("' is invalid. Valid layers are: dataaccess,logic,service,batch,client, or common");
    }
    if (!pkg.isValidScope()) {
      sb.append(" Scope '");
      sb.append(pkg.getScope());
      sb.append("' is invalid. Valid scopes are: api,base, or impl");
    }
    return sb.toString();
  }

}
