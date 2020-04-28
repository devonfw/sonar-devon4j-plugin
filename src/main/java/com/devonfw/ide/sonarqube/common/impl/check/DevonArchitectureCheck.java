package com.devonfw.ide.sonarqube.common.impl.check;

import java.util.ArrayList;
import java.util.List;

import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.ImportTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Modifier;
import org.sonar.plugins.java.api.tree.ModifierKeywordTree;
import org.sonar.plugins.java.api.tree.NewClassTree;
import org.sonar.plugins.java.api.tree.PackageDeclarationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TypeTree;
import org.sonar.plugins.java.api.tree.VariableTree;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * Abstract base class for all SonarQube architecture checks of this plugin.
 */
public abstract class DevonArchitectureCheck extends BaseTreeVisitor implements JavaFileScanner {

  private Devon4jPackage sourcePackage;

  private JavaType sourceType;

  private JavaFileScannerContext context;

  private int packageLine;

  private List<ImportTree> imports;

  /**
   * The constructor.
   */
  public DevonArchitectureCheck() {

    super();
    this.imports = new ArrayList<>();
  }

  /**
   * Called in case of a dependency that is devonfw compliant.
   *
   * @param source the {@link JavaType} to analyze.
   * @param target the {@link JavaType} used by the source type (as dependency).
   * @return the message of an issue to create due to an undesired dependency or {@code null} if dependency is fine.
   */
  protected abstract String checkDependency(JavaType source, JavaType target);

  @Override
  public void scanFile(JavaFileScannerContext fileContext) {

    this.imports.clear();
    this.context = fileContext;
    scan(fileContext.getTree());
    this.context = null;
    this.sourcePackage = null;
  }

  @Override
  public void visitImport(ImportTree tree) {

    this.imports.add(tree);
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

    IdentifierTree simpleNameTree = classTree.simpleName();
    String simpleName;
    if (simpleNameTree == null) {
      simpleName = "";
    } else {
      simpleName = simpleNameTree.name();
    }
    this.sourceType = new JavaType(this.sourcePackage, simpleName);
    for (ImportTree tree : this.imports) {
      String qualifiedName = getQualifiedName(tree.qualifiedIdentifier());
      checkIfDisallowed(qualifiedName, tree);
    }
    if (classTree.parent() instanceof CompilationUnitTree) {
      String warning = createIssueForInvalidSourcePackage(this.sourceType, classTree);
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

    if (!isTreeAndSourcePackageValid(tree) || className == null) {
      return;
    }

    int lastDot = className.lastIndexOf('.');
    if (lastDot <= 0) {
      return;
    }

    String pkgName = className.substring(0, lastDot);
    String simpleName = className.substring(lastDot + 1);
    Devon4jPackage targetPkg = Devon4jPackage.of(pkgName);
    JavaType targetType = new JavaType(targetPkg, simpleName);
    String warning = null;

    if (!targetPkg.isValid() || (targetPkg.getRoot() == null)) {
      if (isCheckDependencyOnInvalidPackage()) {
        warning = checkDependency(this.sourceType, targetType);
      }
    } else {
      String targetRoot = targetPkg.getRoot();
      if ("com.devonfw".equals(targetRoot) && !isSameRootApplication(this.sourceType, targetType)
          && isTargetDependencyAllowed(targetPkg)) {
        return;
      }
      warning = checkDependency(this.sourceType, targetType);
    }

    if (warning != null) {
      int line = tree.firstToken().line();
      this.context.addIssue(line, this, warning);
    }

  }

  private boolean isTreeAndSourcePackageValid(Tree tree) {

    return (!tree.is(Tree.Kind.INFERED_TYPE) && this.sourcePackage != null && this.sourcePackage.isValid());
  }

  private boolean isTargetDependencyAllowed(Devon4jPackage targetPkg) {

    boolean targetDependencyAllowed;
    String targetComponent = targetPkg.getComponent();

    if (targetComponent.equals("jpa")) {
      targetDependencyAllowed = this.sourcePackage.isLayerDataAccess();
    } else if (targetComponent.equals("batch")) {
      targetDependencyAllowed = this.sourcePackage.isLayerBatch();
    } else {
      targetDependencyAllowed = true;
    }

    return targetDependencyAllowed;
  }

  /**
   * @return {@code true} if {@link #checkDependency(JavaType, JavaType)} shall also be called for invalid target
   *         packages, {@code false} otherwise.
   */
  protected boolean isCheckDependencyOnInvalidPackage() {

    return false;
  }

  @Override
  public void visitPackage(PackageDeclarationTree tree) {

    String qualifiedName = getQualifiedName(tree.packageName());
    this.sourcePackage = Devon4jPackage.of(qualifiedName);
    this.packageLine = tree.firstToken().line();
    this.sourceType = new JavaType(this.sourcePackage, null);
    super.visitPackage(tree);
  }

  /**
   * @param tree the {@link Tree} name to traverse.
   * @return the qualified name.
   */
  protected String getQualifiedName(Tree tree) {

    if (tree == null) {
      return "";
    }
    QualifiedNameVisitor qnameVisitor = new QualifiedNameVisitor();
    tree.accept(qnameVisitor);
    return qnameVisitor.getQualifiedName();
  }

  /**
   * Returns all methods of the given tree.
   *
   * @param tree Tree currently being investigated.
   * @return List of MethodTree.
   */
  protected List<MethodTree> getMethodsOfTree(ClassTree tree) {

    List<Tree> membersOfTree = tree.members();
    List<MethodTree> methodsOfTree = new ArrayList<>();

    for (Tree member : membersOfTree) {
      if (member.is(Tree.Kind.METHOD)) {
        methodsOfTree.add((MethodTree) member);
      }
    }

    return methodsOfTree;
  }

  /**
   * Checks if a method has a public modifier.
   *
   * @param method to be checked
   * @return true or false
   */
  protected boolean isMethodPublic(MethodTree method) {

    for (ModifierKeywordTree modifier : method.modifiers().modifiers()) {
      if (modifier.modifier() == Modifier.PUBLIC) {
        return true;
      }
    }

    return false;
  }

  /**
   * @param source the {@link JavaType} of the source type to analyze.
   * @param classTree the {@link ClassTree} of the top-level type.
   * @return the message of an issue to create in case the source package itself is invalid.
   */
  protected String createIssueForInvalidSourcePackage(JavaType source, ClassTree classTree) {

    return null;
  }

  /**
   * @param source the {@link JavaType} of the source type.
   * @param target the {@link JavaType} of the target type referenced from the source type.
   * @return {@code true} if both {@link JavaType}s have the same {@link JavaType#getRoot() root package}, {@code false}
   *         otherwise.
   */
  protected boolean isSameRoot(JavaType source, JavaType target) {

    return source.getRoot().equals(target.getRoot());
  }

  /**
   * @param source the {@link JavaType} of the source type.
   * @param target the {@link JavaType} of the target type referenced from the source type.
   * @return {@code true} if both {@link JavaType}s have the same {@link JavaType#getApplication() application},
   *         {@code false} otherwise.
   */
  protected boolean isSameApplication(JavaType source, JavaType target) {

    return source.getApplication().equals(target.getApplication());
  }

  /**
   * @param source the {@link JavaType} of the source type.
   * @param target the {@link JavaType} of the target type referenced from the source type.
   * @return {@code true} if both {@link JavaType}s have the same {@link JavaType#getApplication() application},
   *         {@code false} otherwise.
   */
  protected boolean isSameRootApplication(JavaType source, JavaType target) {

    return isSameRoot(source, target) && isSameApplication(source, target);
  }

  /**
   * @param source the {@link JavaType} of the source type.
   * @param target the {@link JavaType} of the target type referenced from the source type.
   * @return {@code true} if both {@link JavaType}s have the same {@link JavaType#getComponent() component},
   *         {@code false} otherwise.
   */
  protected boolean isSameComponent(JavaType source, JavaType target) {

    return source.getComponent().equals(target.getComponent());
  }

  /**
   * @param source the {@link JavaType} of the source type.
   * @param target the {@link JavaType} of the target type referenced from the source type.
   * @return {@code true} if both {@link JavaType}s have the same {@link JavaType#getLayer() layer}, {@code false}
   *         otherwise.
   */
  protected boolean isSameLayer(JavaType source, JavaType target) {

    return source.getLayer().equals(target.getLayer());
  }

  /**
   * @param source the {@link JavaType} of the source type.
   * @param target the {@link JavaType} of the target type referenced from the source type.
   * @return {@code true} if both {@link JavaType}s have the same {@link JavaType#getComponent() component} and
   *         {@link JavaType#getLayer() layer}, {@code false} otherwise.
   */
  protected boolean isSameComponentPart(JavaType source, JavaType target) {

    return isSameRootApplication(source, target) && isSameComponent(source, target) && isSameLayer(source, target);
  }

  /**
   * @param source the {@link JavaType} of the source type.
   * @param target the {@link JavaType} of the target type referenced from the source type.
   * @return {@code true} if both {@link JavaType}s have the same {@link JavaType#getComponent() component} and
   *         {@link JavaType#getLayer() layer}, {@code false} otherwise.
   */
  protected boolean isSameOrGeneralComponentWithSameOrCommonLayer(JavaType source, JavaType target) {

    if (target.isLayerCommon() || (target.getLayer().equals(source.getLayer()))) {
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