package com.devonfw.ide.sonarqube.common.impl.check.packaging;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} verifying the devon package conventions.
 */
@Rule(key = "P1", name = "devonfw Package Check", //
    priority = Priority.BLOCKER, tags = { "architecture-violation", "devonfw", "package" })
public class DevonArchitecturePackageCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

  @Override
  protected String createIssueForInvalidSourcePackage(JavaType source, ClassTree classTree) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    if (sourcePkg.isValid()) {
      return null;
    }

    if (!sourcePkg.isValidLayer() && !sourcePkg.isValidScope() && (classTree.kind() == Kind.CLASS)
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

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    StringBuilder sb = new StringBuilder(64);
    sb.append("The package of type '");
    sb.append(source.getQualifiedName());
    sb.append("' is not compliant with your architecture. ");
    if (!sourcePkg.isValidLayer()) {
      sb.append(" Layer '");
      sb.append(sourcePkg.getUnresolved().getLayer());
      sb.append("' is undefined. ");
    }
    if (!sourcePkg.isValidScope()) {
      sb.append(" Scope '");
      sb.append(sourcePkg.getUnresolved().getScope());
      sb.append("' is undefined. ");
    }
    sb.append("Please follow the devonfw naming conventions for packages: ");
    sb.append("https://github.com/devonfw/devon4j/wiki/coding-conventions#packages");
    return sb.toString();
  }

}
