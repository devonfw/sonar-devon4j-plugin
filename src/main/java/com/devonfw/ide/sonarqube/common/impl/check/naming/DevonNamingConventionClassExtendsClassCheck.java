package com.devonfw.ide.sonarqube.common.impl.check.naming;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.sonar.java.model.ModifiersUtils;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Modifier;
import org.sonar.plugins.java.api.tree.TypeTree;

import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * Abstract base class for naming convention checks of classes. This class only checks if the checked class has the same
 * suffix as its superclass.
 */
public abstract class DevonNamingConventionClassExtendsClassCheck extends DevonArchitectureCheck {

  /**
   * This needs to be the suffix of the checked class if it extends a certain other class.
   */
  protected final Pattern classSuffixRegEx;

  /**
   * Name of the checked class
   */
  protected String className;

  /**
   * Name of the superclass of the checked class
   */
  protected String superClassName;

  /**
   *
   * The constructor.
   *
   * @param classSuffix See JavaDoc on variable declaration.
   */
  public DevonNamingConventionClassExtendsClassCheck(String classSuffix) {

    this.classSuffixRegEx = Pattern.compile(classSuffix);
  }

  /**
   * Method called after parsing and semantic analysis has been done on file.
   *
   * @param context Context of analysis containing the parsed tree.
   */
  @Override
  public void doScanFile(ClassTree tree, JavaFileScannerContext context) {

    this.className = tree.simpleName().name();
    this.superClassName = getNameOfSuperClass(tree);

    if (isSuperClassMatching()) {
      checkClassNameAndCreateIssue(tree, context);
    }
  }

  /**
   * Checks if class name is matching the given pattern. If not, creates an issue.
   *
   * @param tree Tree currently being investigated.
   * @param context Context of analysis containing the parsed tree.
   * @return true if issue was created, false otherwise.
   */
  protected boolean checkClassNameAndCreateIssue(ClassTree tree, JavaFileScannerContext context) {

    if (!isClassNameMatching()) {
      context.addIssue(tree.openBraceToken().line(), this, "If a superclass has " + this.classSuffixRegEx
          + " as suffix, then the subclass should also have " + this.classSuffixRegEx + " as suffix");
      return true;
    }
    return false;
  }

  /**
   * Gets the name of the super class of the currently checked class.
   *
   * @param tree Tree currently being investigated.
   * @return Name of the super class.
   */
  protected String getNameOfSuperClass(ClassTree tree) {

    TypeTree superClass = tree.superClass();

    if (superClass == null) {
      return null;
    } else {
      return tree.superClass().toString();
    }
  }

  /**
   * Gets the names of all the interfaces implemented by the currently checked class.
   *
   * @param tree Tree currently being investigated.
   * @return Names of the implemented interfaces.
   */
  protected List<String> getSuperInterfacesNames(ClassTree tree) {

    List<TypeTree> superInterfaces = tree.superInterfaces();
    List<String> superInterfacesNames = new ArrayList<>();

    for (TypeTree superInterface : superInterfaces) {
      superInterfacesNames.add(superInterface.toString());
    }

    return superInterfacesNames;
  }

  /**
   * Checks if the currently checked class is abstract or not.
   *
   * @param tree Tree currently being investigated.
   * @return True or false.
   */
  protected static boolean isAbstract(ClassTree tree) {

    return ModifiersUtils.hasModifier(tree.modifiers(), Modifier.ABSTRACT);
  }

  /**
   * Checks if the currently checked class is of a certain type.
   *
   * @return True or false.
   */
  protected boolean isClassNameMatching() {

    return (this.classSuffixRegEx.matcher(this.className).matches());
  }

  /**
   * Checks if the checked class is inheriting from a certain class.
   *
   * @return True or false.
   */
  protected boolean isSuperClassMatching() {

    if (this.superClassName == null) {
      return false;
    } else {
      return this.classSuffixRegEx.matcher(this.superClassName).matches();
    }
  }

}
