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

    StringBuilder sb = new StringBuilder(64);
    sb.append("The package '");
    sb.append(pkg.toString());
    sb.append("' is not a valid OASP package.");
    if (!pkg.isValidLayer()) {
      // Hinweis layer fehlt oder unbekannt, muss dataaccess,logic,service,batch,client oder common
      sb.append("Layer '");
      sb.append(pkg.getLayer());
      sb.append("' is not a valid layer. Valid layers are: dataaccess,logic,service,batch,client or common");
    }
    if (!pkg.isValidScope()) {
      String scope = pkg.getScope();
      // Hinweis scope muss api/base/impl sein

    }
    return sb.toString();
  }

}
