package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureCheck} verifying the devon package conventions.
 */
@Rule(key = "Devon4j:P1", name = "Devon Package Check", description = "Verify the devon package conventions.", //
    priority = Priority.BLOCKER, tags = { "bug" })
public class DevonArchitecturePackageCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    return null;
  }

  @Override
  protected String createIssueForInvalidSourcePackage(Devon4jPackage pkg, ClassTree classTree) {

    if (pkg.isValid()) {
      return null;
    }
    if (!pkg.isValidLayer() && !pkg.isValidScope()) {
      if ((classTree.kind() == Kind.CLASS) && classTree.simpleName().name().matches("SpringBoot[a-zA-Z0-9]*App")) {
        return null;
      }
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
