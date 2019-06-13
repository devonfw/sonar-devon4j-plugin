package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitectureCheck} verifying the devon package conventions.
 */
@Rule(key = "Devon4j:P1", name = "Devon Package Check", description = "Verify the devon package conventions.", //
    priority = Priority.BLOCKER, tags = { "architecture-violation" })
public class DevonArchitecturePackageCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

  @Override
  protected String createIssueForInvalidSourcePackage(JavaType source, ClassTree classTree) {

    if (source.isValid()) {
      return null;
    }
    if (!source.isValidLayer() && !source.isValidScope()) {
      if (classTree.kind() == Kind.CLASS) {
        for (AnnotationTree annotation : classTree.modifiers().annotations()) {
          String annotationType = getQualifiedName(annotation.annotationType());
          if ("org.springframework.boot.autoconfigure.SpringBootApplication".equals(annotationType)) {
            return null;
          }
        }
        String classSimpleName = classTree.simpleName().name();
        if (classSimpleName.matches("SpringBoot[a-zA-Z0-9]*App")
            || classSimpleName.matches("[a-zA-Z0-9]*Application")) {
          return null;
        }
      }
    }
    StringBuilder sb = new StringBuilder(64);
    sb.append("The package '");
    sb.append(source.toString());
    sb.append("' is not compliant with your architecture.");
    if (!source.isValidLayer()) {
      sb.append(" Layer '");
      sb.append(source.getLayer());
      sb.append("' is invalid. Valid layers are: dataaccess,logic,service,batch,client, or common");
    }
    if (!source.isValidScope()) {
      sb.append(" Scope '");
      sb.append(source.getScope());
      sb.append("' is invalid. Valid scopes are: api,base, or impl");
    }
    return sb.toString();
  }

}
