package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.ImportTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.NewClassTree;
import org.sonar.plugins.java.api.tree.PackageDeclarationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TypeTree;
import org.sonar.plugins.java.api.tree.VariableTree;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * Abstract base class for all SonarQube architecture checks of this plugin.
 */
public abstract class DevonArchitectureCheck extends BaseTreeVisitor implements JavaFileScanner {

  private Devon4jPackage sourcePackage;

  private JavaFileScannerContext context;

  /**
   * The constructor.
   */
  public DevonArchitectureCheck() {

    super();
  }

  /**
   * @param source the {@link Devon4jPackage} of the type to analyze.
   * @param target the {@link Devon4jPackage} of a type used by the type to analyze.
   * @param targetTypeSimpleName the {@link Class#getSimpleName() simple name} of the type to analyze.
   * @return the message of an issue to create due to an undesired dependency or {@code null} if dependency is fine.
   */
  protected abstract String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName);

  @Override
  public void scanFile(JavaFileScannerContext fileContext) {

    this.context = fileContext;
    scan(fileContext.getTree());
    this.context = null;
    this.sourcePackage = null;
  }

  @Override
  public void visitImport(ImportTree tree) {

    String qualifiedName = getQualifiedName(tree.qualifiedIdentifier());
    checkIfDisallowed(qualifiedName, tree);
    super.visitImport(tree);
  }

  @Override
  public void visitVariable(VariableTree variableTree) {

    String qualifiedName = getQualifiedName(variableTree);
    checkIfDisallowed(qualifiedName, variableTree.type());
    super.visitVariable(variableTree);
  }

  @Override
  public void visitMethod(MethodTree methodTree) {

    if (methodTree.returnType() != null) {
      String returnTypeName = getQualifiedName(methodTree.returnType());
      checkIfDisallowed(returnTypeName, methodTree.returnType());
    }
    super.visitMethod(methodTree);
  }

  @Override
  public void visitNewClass(NewClassTree newClassTree) {

    String newClassTypeName = getQualifiedName(newClassTree.identifier());
    Tree parent = newClassTree.parent();
    if (parent != null && !parent.is(Tree.Kind.VARIABLE)) {
      checkIfDisallowed(newClassTypeName, newClassTree);
    }
    super.visitNewClass(newClassTree);
  }

  @Override
  public void visitClass(ClassTree classTree) {

    TypeTree superClass = classTree.superClass();
    if (superClass != null) {
      String superClassTypeName = superClass.symbolType().fullyQualifiedName();
      checkIfDisallowed(superClassTypeName, superClass);
    }
    super.visitClass(classTree);
  }

  private void checkIfDisallowed(String className, Tree tree) {

    if (tree.is(Tree.Kind.INFERED_TYPE)) {
      return;
    }
    if (this.sourcePackage == null) {
      return;
    }
    int lastDot = className.lastIndexOf('.');
    if (lastDot <= 0) {
      return;
    }
    String pkgName = className.substring(0, lastDot);
    String simpleName = className.substring(lastDot + 1);
    Devon4jPackage targetPkg = Devon4jPackage.of(pkgName);
    if (!targetPkg.isValid()) {
      return;
    }
    String warning = checkDependency(this.sourcePackage, targetPkg, simpleName);
    if (warning != null) {
      int line = tree.firstToken().line();
      this.context.addIssue(line, this, warning);
    }
  }

  @Override
  public void visitPackage(PackageDeclarationTree tree) {

    QualifiedNameVisitor qnameVisitor = new QualifiedNameVisitor();
    tree.packageName().accept(qnameVisitor);
    String qualifiedName = qnameVisitor.getQualifiedName();
    Devon4jPackage pkg = Devon4jPackage.of(qualifiedName);
    String warning = createIssueForInvalidSourcePackage(pkg);
    if (warning != null) {
      int line = tree.firstToken().line();
      this.context.addIssue(line, this, warning);
    }
    if (pkg.isValid()) {
      this.sourcePackage = pkg;
    } else {
      this.sourcePackage = null;
    }
    super.visitPackage(tree);
  }

  private String getQualifiedName(Tree tree) {

    QualifiedNameVisitor qnameVisitor = new QualifiedNameVisitor();
    tree.accept(qnameVisitor);
    return qnameVisitor.getQualifiedName();
  }

  /**
   * @param pkg the {@link Devon4jPackage} of the source type to analyze.
   * @return the message of an issue to create in case the source package itself is invalid.
   */
  protected String createIssueForInvalidSourcePackage(Devon4jPackage pkg) {

    return null;
  }

}