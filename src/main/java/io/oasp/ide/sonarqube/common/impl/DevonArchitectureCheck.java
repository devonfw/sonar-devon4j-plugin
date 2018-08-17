package io.oasp.ide.sonarqube.common.impl;

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

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * TODO: JavaDoc
 */
public abstract class DevonArchitectureCheck extends BaseTreeVisitor implements JavaFileScanner {

  private OaspPackage sourcePackage;

  private JavaFileScannerContext context;

  /**
   * The constructor.
   */
  public DevonArchitectureCheck() {

    super();
  }

  protected abstract String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName);

  @Override
  public void scanFile(JavaFileScannerContext context) {

    this.context = context;
    scan(context.getTree());
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
    OaspPackage targetPkg = OaspPackage.of(pkgName);
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
    OaspPackage pkg = OaspPackage.of(qualifiedName);
    if (pkg.isValid()) {
      this.sourcePackage = pkg;

      String warning = createIssueForSourcePackage(pkg);
      if (warning != null) {
        int line = tree.firstToken().line();
        this.context.addIssue(line, this, warning);
      }
    } else {
      String warning = createIssueForInvalidSourcePackage(pkg);
      if (warning != null) {
        int line = tree.firstToken().line();
        this.context.addIssue(line, this, warning);
      }
      this.sourcePackage = null;
    }
    super.visitPackage(tree);
  }

  /**
   * @param pkg
   * @return
   */
  protected String createIssueForSourcePackage(OaspPackage pkg) {

    return null;
  }

  private String getQualifiedName(Tree tree) {

    QualifiedNameVisitor qnameVisitor = new QualifiedNameVisitor();
    tree.accept(qnameVisitor);
    return qnameVisitor.getQualifiedName();
  }

  /**
   * @param pkg
   */
  protected String createIssueForInvalidSourcePackage(OaspPackage pkg) {

    return null;
  }

}