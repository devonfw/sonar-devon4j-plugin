package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.sonar.java.model.ModifiersUtils;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.Modifier;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TypeTree;

/**
 * Abstract base class for naming convention checks of classes. This class only checks if the checked class has the same
 * suffix as its superclass.
 */
public abstract class DevonNamingConventionClassExtendsClassCheck implements JavaFileScanner {

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
  public void scanFile(JavaFileScannerContext context) {

    ClassTree tree = getTreeInstance(context);
    this.className = tree.simpleName().name();
    this.superClassName = getNameOfSuperClass(tree);

    if (isSuperClassMatching() && !isClassNameMatching()) {
      context.addIssueOnFile(this, "If a superclass has " + this.classSuffixRegEx
          + " as suffix, then the subclass should also have " + this.classSuffixRegEx + " as suffix");
    }
  }

  /**
   * Gets a tree instance from the current context.
   *
   * @param context Current context.
   * @return Tree instance.
   */
  protected static ClassTree getTreeInstance(JavaFileScannerContext context) {

    CompilationUnitTree parsedTree = context.getTree();
    List<Tree> types = parsedTree.types();

    for (Tree tree : types) {
      if (tree instanceof ClassTree) {
        return (ClassTree) tree;
      }
    }
    return null;
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

    if (this.classSuffixRegEx.matcher(this.className).matches()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks if the checked class is inheriting from a certain class.
   *
   * @return True or false.
   */
  protected boolean isSuperClassMatching() {

    if (this.classSuffixRegEx.matcher(this.superClassName).matches()) {
      return true;
    } else {
      return false;
    }
  }

}
