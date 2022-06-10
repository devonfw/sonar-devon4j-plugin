package com.devonfw.ide.sonarqube.common.impl.check.naming;

import java.util.regex.Pattern;

import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TypeTree;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCodeCheck;

/**
 * Abstract base class for naming convention checks of classes. This class only checks if the checked class has the same
 * suffix as its superclass.
 */
public abstract class DevonNamingConventionCheck extends DevonArchitectureCodeCheck {

  private final Pattern classNamePattern;

  private final Pattern superClassNamePattern;

  /**
   *
   * The constructor.
   *
   * @param classNamePattern the {@link Pattern#compile(String) regex pattern} the {@link Class#getSimpleName() simple
   *        name} of the class and its super-class should match.
   */
  public DevonNamingConventionCheck(String classNamePattern) {

    super();
    this.classNamePattern = Pattern.compile(classNamePattern);
    this.superClassNamePattern = this.classNamePattern;
  }

  /**
   *
   * The constructor.
   *
   * @param superClassNamePattern the {@link Pattern#compile(String) regex pattern} the super-class-name should match or
   *        this check does not apply.
   * @param classNamePattern the {@link Pattern#compile(String) regex pattern} the classname should match or an issue is
   *        created. However, if the class is abstract, the {@code superClassNamePattern} should match for the
   *        class-name instead.
   */
  public DevonNamingConventionCheck(String superClassNamePattern, String classNamePattern) {

    super();
    this.classNamePattern = Pattern.compile(classNamePattern);
    this.superClassNamePattern = Pattern.compile(superClassNamePattern);
  }

  /**
   * @return classNamePattern
   */
  protected Pattern getClassNamePattern() {

    return this.classNamePattern;
  }

  /**
   * Method called after parsing and semantic analysis has been done on file.
   *
   * @param context Context of analysis containing the parsed tree.
   */
  @Override
  public void doScanFile(ClassTree tree, JavaFileScannerContext context) {

    if (tree.is(Tree.Kind.CLASS)) {
      String superClassName = getSimpleNameOfSuperClass(tree);
      if ((superClassName != null) && this.superClassNamePattern.matcher(superClassName).matches()) {
        doCheckClass(tree, context);
      }
    } else {
      for (TypeTree superInterface : tree.superInterfaces()) {
        String superInterfaceName = superInterface.toString();
        if (this.superClassNamePattern.matcher(superInterfaceName).matches()) {
          doCheckClass(tree, context);
          break;
        }
      }
    }
  }

  /**
   * Called if the super-class is matching and this check should apply. Checks the given {@link ClassTree} and creates
   * issues if rule is violated.
   *
   * @param tree the {@link ClassTree} of the class to check.
   * @param context the {@link JavaFileScannerContext}.
   */
  protected void doCheckClass(ClassTree tree, JavaFileScannerContext context) {

    Pattern namePattern = this.classNamePattern;
    boolean isAbstract = isAbstract(tree);
    boolean superClassIfAbstract = isUseSuperClassPatternIfAbstract();

    String className = tree.simpleName().name();
    if (superClassIfAbstract && isAbstract) {
      namePattern = this.superClassNamePattern;
    } else if ((this.classNamePattern != this.superClassNamePattern) && className.endsWith("Impl")) {
      String interfaceName = className.substring(0, className.length() - 4);
      String message = getIssueMessageForMissingInterface(interfaceName);
      if ((message != null) && !hasSuperInterfacesWithSimpleName(tree, interfaceName)) {
        context.addIssue(tree.openBraceToken().line(), this, message);
      }
    }
    if (!namePattern.matcher(className).matches()) {
      StringBuilder message = new StringBuilder(64);
      message.append("If superclass is matching '");
      message.append(this.superClassNamePattern);
      message.append("', then a ");
      if (this.classNamePattern == this.superClassNamePattern) {
        message.append("subclass should also match this pattern.");
      } else {
        if (!isAbstract) {
          message.append("non-");
        }
        message.append("abstract subclass should ");
        if (namePattern == this.superClassNamePattern) {
          message.append("also match this pattern.");
        } else {
          message.append("match '");
          message.append(namePattern);
          message.append(".");
        }
      }
      context.addIssue(tree.openBraceToken().line(), this, message.toString());
    }
  }

  /**
   * @param interfaceName the {@link Class#getSimpleName() simple name} of a potentially expected interface that should
   *        be implemented.
   * @return the according issue message if such interface is required but not present or {@code null} to ignore.
   */
  protected String getIssueMessageForMissingInterface(String interfaceName) {

    return null;
  }

  /**
   * @return {@code true} if the class name pattern ends with "Impl" and the class should implement an interface with
   *         the same name but without the "Impl" suffix, {@code false} otherwise (default).
   */
  protected boolean isRequireInterfaceNamedWithoutImpl() {

    return false;
  }

  /**
   * @return {@code true} if the super-class-name-pattern should be matched if the type is abstract, {@code false}
   *         otherwise.
   */
  protected boolean isUseSuperClassPatternIfAbstract() {

    return true;
  }

}
