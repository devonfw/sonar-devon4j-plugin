package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.ImportTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.NewClassTree;
import org.sonar.plugins.java.api.tree.PackageDeclarationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TypeTree;
import org.sonar.plugins.java.api.tree.VariableTree;

import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * Abstract base class for all SonarQube architecture checks of this plugin.
 */
public abstract class DevonArchitectureCheck extends BaseTreeVisitor implements JavaFileScanner {

  private Devon4jPackage sourcePackage;

  private JavaFileScannerContext context;

  private int packageLine;

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

    if (classTree.parent() instanceof CompilationUnitTree) {
      String warning = createIssueForInvalidSourcePackage(this.sourcePackage, classTree);
      if (warning != null) {
        if (this.sourcePackage == null) {
          this.packageLine = classTree.firstToken().line();
        }
        this.context.addIssue(this.packageLine, this, warning);
      }
    }
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
    if ((this.sourcePackage == null) || !this.sourcePackage.isValid()) {
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
    if (targetPkg.getRoot().equals("com.devonfw")) {
      boolean targetDependencyAllowed;
      String targetApp = targetPkg.getApplication();
      if (targetApp.equals("jpa")) {
        targetDependencyAllowed = this.sourcePackage.isLayerDataAccess();
      } else if (targetApp.equals("batch")) {
        targetDependencyAllowed = this.sourcePackage.isLayerBatch();
      } else if (targetApp.equals("json")) {
        targetDependencyAllowed = this.sourcePackage.isLayerCommon();
      } else {
        targetDependencyAllowed = true;
      }
      if (targetDependencyAllowed) {
        return;
      }
    }
    String warning = checkDependency(this.sourcePackage, targetPkg, simpleName);
    if (warning != null) {
      int line = tree.firstToken().line();
      this.context.addIssue(line, this, warning);
    }
  }

  @Override
  public void visitPackage(PackageDeclarationTree tree) {

    String qualifiedName = getQualifiedName(tree.packageName());
    this.sourcePackage = Devon4jPackage.of(qualifiedName);
    this.packageLine = tree.firstToken().line();
    super.visitPackage(tree);
  }

  private String getQualifiedName(Tree tree) {

    if (tree == null) {
      return "";
    }
    QualifiedNameVisitor qnameVisitor = new QualifiedNameVisitor();
    tree.accept(qnameVisitor);
    return qnameVisitor.getQualifiedName();
  }

  /**
   * @param pkg the {@link Devon4jPackage} of the source type to analyze.
   * @param classTree the {@link ClassTree} of the top-level type.
   * @return the message of an issue to create in case the source package itself is invalid.
   */
  protected String createIssueForInvalidSourcePackage(Devon4jPackage pkg, ClassTree classTree) {

    return null;
  }

  /**
   * @param source the {@link Devon4jPackage} of the source type.
   * @param target the {@link Devon4jPackage} of the target type referenced from the source type.
   * @return {@code true} if both {@link Devon4jPackage packages} have the same {@link Devon4jPackage#getRoot() root
   *         package}, {@code false} otherwise.
   */
  protected boolean isSameRoot(Devon4jPackage source, Devon4jPackage target) {

    return source.getRoot().equals(target.getRoot());
  }

  /**
   * @param source the {@link Devon4jPackage} of the source type.
   * @param target the {@link Devon4jPackage} of the target type referenced from the source type.
   * @return {@code true} if both {@link Devon4jPackage packages} have the same {@link Devon4jPackage#getApplication()
   *         application}, {@code false} otherwise.
   */
  protected boolean isSameApplication(Devon4jPackage source, Devon4jPackage target) {

    return source.getApplication().equals(target.getApplication());
  }

  /**
   * @param source the {@link Devon4jPackage} of the source type.
   * @param target the {@link Devon4jPackage} of the target type referenced from the source type.
   * @return {@code true} if both {@link Devon4jPackage packages} have the same {@link Devon4jPackage#getApplication()
   *         application}, {@code false} otherwise.
   */
  protected boolean isSameRootApplication(Devon4jPackage source, Devon4jPackage target) {

    return isSameRoot(source, target) && isSameApplication(source, target);
  }

  /**
   * @param source the {@link Devon4jPackage} of the source type.
   * @param target the {@link Devon4jPackage} of the target type referenced from the source type.
   * @return {@code true} if both {@link Devon4jPackage packages} have the same {@link Devon4jPackage#getComponent()
   *         component}, {@code false} otherwise.
   */
  protected boolean isSameComponent(Devon4jPackage source, Devon4jPackage target) {

    return source.getComponent().equals(target.getComponent());
  }

  /**
   * @param source the {@link Devon4jPackage} of the source type.
   * @param target the {@link Devon4jPackage} of the target type referenced from the source type.
   * @return {@code true} if both {@link Devon4jPackage packages} have the same {@link Devon4jPackage#getLayer() layer},
   *         {@code false} otherwise.
   */
  protected boolean isSameLayer(Devon4jPackage source, Devon4jPackage target) {

    return source.getLayer().equals(target.getLayer());
  }

  /**
   * @param source the {@link Devon4jPackage} of the source type.
   * @param target the {@link Devon4jPackage} of the target type referenced from the source type.
   * @return {@code true} if both {@link Devon4jPackage packages} have the same {@link Devon4jPackage#getComponent()
   *         component} and {@link Devon4jPackage#getLayer() layer}, {@code false} otherwise.
   */
  protected boolean isSameComponentPart(Devon4jPackage source, Devon4jPackage target) {

    return isSameRootApplication(source, target) && isSameComponent(source, target) && isSameLayer(source, target);
  }

  /**
   * @param source the {@link Devon4jPackage} of the source type.
   * @param target the {@link Devon4jPackage} of the target type referenced from the source type.
   * @return {@code true} if both {@link Devon4jPackage packages} have the same {@link Devon4jPackage#getComponent()
   *         component} and {@link Devon4jPackage#getLayer() layer}, {@code false} otherwise.
   */
  protected boolean isSameComponentOrGeneralWithCommonLayer(Devon4jPackage source, Devon4jPackage target) {

    if (target.isLayerCommon()) {
      String targetComponent = target.getComponent();
      if (targetComponent.equals(Component.NAME_GENERAL)) {
        return true;
      }
      if (targetComponent.equals(source.getComponent()) && isSameRootApplication(source, target)) {
        return true;
      }
    }
    return false;
  }

}