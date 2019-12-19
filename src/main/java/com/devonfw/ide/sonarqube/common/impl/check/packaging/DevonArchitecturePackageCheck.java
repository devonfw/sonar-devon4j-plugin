package com.devonfw.ide.sonarqube.common.impl.check.packaging;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} verifying the devon package conventions.
 */
@Rule(key = "P1", name = "Devon Package Check", //
    priority = Priority.BLOCKER, tags = { "architecture-violation", "devonfw", "package" })
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

    if (!source.isValidLayer() && !source.isValidScope() && classTree.kind() == Kind.CLASS
        && isSpringBootApplicationClass(classTree)) {
      return null;
    }

    return buildIssueString(source);
  }

  private boolean isSpringBootApplicationClass(ClassTree classTree) {

    for (AnnotationTree annotation : classTree.modifiers().annotations()) {
      String annotationType = getQualifiedName(annotation.annotationType());
      if ("org.springframework.boot.autoconfigure.SpringBootApplication".equals(annotationType)) {
        return true;
      }
    }
    String classSimpleName = classTree.simpleName().name();

    return classSimpleName.matches("SpringBoot[a-zA-Z0-9]*App") || classSimpleName.matches("[a-zA-Z0-9]*Application");
  }

  private String buildIssueString(JavaType source) {

    StringBuilder sb = new StringBuilder(64);
    sb.append("The package '");
    sb.append(source.toString());
    sb.append("' is not compliant with your architecture. ");
    if (!source.isValidLayer()) {
      sb.append(" Layer '");
      sb.append(source.getLayer());
      sb.append("' is invalid. Valid layers are: dataaccess, logic, service, batch, client, or common. ");
    }
    if (!source.isValidScope()) {
      sb.append(" Scope '");
      sb.append(source.getScope());
      sb.append("' is invalid. Valid scopes are: api, base, or impl. ");
    }
    sb.append("Please follow the devonfw naming conventions for packages: ");
    sb.append("https://github.com/devonfw/devon4j/wiki/coding-conventions#packages");
    return sb.toString();
  }

}
