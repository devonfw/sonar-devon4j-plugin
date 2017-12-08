package io.oasp.ide.sonarqube.common.impl;

import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;

/**
 * @author ssabah
 *
 */
public class QualifiedNameVisitor extends BaseTreeVisitor {

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
