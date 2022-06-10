package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;

/**
 * {@link BaseTreeVisitor} to build and get the {@link Class#getName() qualified name} of a type from the SonarQube AST.
 */
class QualifiedNameVisitor extends BaseTreeVisitor {

  private final StringBuilder buffer;

  /**
   * The constructor.
   */
  public QualifiedNameVisitor() {

    super();
    this.buffer = new StringBuilder();
  }

  @Override
  public void visitIdentifier(IdentifierTree tree) {

    if (this.buffer.length() > 0) {
      this.buffer.append('.');
    }
    this.buffer.append(tree.name());
  }

  public String getQualifiedName() {

    return this.buffer.toString();
  }

}
