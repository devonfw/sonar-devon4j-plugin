package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TypeTree;

/**
 * Abstract base class for naming convention checks of interfaces
 */
public abstract class DevonNamingConventionInterfaceExtendsInterfaceCheck implements JavaFileScanner {

  /**
   * This needs to be the suffix of the checked interface if it extends certain other interfaces.
   */
  protected final String extendingInterfaceSuffix;

  /**
   * The constructor.
   *
   * @param extendingInterfaceSuffix See JavaDoc on variable declaration.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceCheck(String extendingInterfaceSuffix) {

    this.extendingInterfaceSuffix = extendingInterfaceSuffix;
  }

  /**
   * Method called after parsing and semantic analysis has been done on file.
   *
   * @param context Context of analysis containing the parsed tree.
   */
  @Override
  public void scanFile(JavaFileScannerContext context) {

    ClassTree tree = getTreeInstance(context);
    String interfaceName = tree.simpleName().name();
    Set<String> superInterfacesNames = getSuperInterfacesNames(tree);
    Pattern pattern = Pattern.compile(this.extendingInterfaceSuffix);

    if (doesSuperInterfaceHaveRegEx(superInterfacesNames, pattern) && !doesInterfaceHaveRegEx(interfaceName, pattern)) {
      context.addIssueOnFile(this, "If a superinterface has " + this.extendingInterfaceSuffix
          + " as suffix, then the subinterface should also have " + this.extendingInterfaceSuffix + " as suffix");
      return;
    }

  }

  private static ClassTree getTreeInstance(JavaFileScannerContext context) {

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
   * Gets the names of all super interfaces of the checked interface.
   *
   * @param tree Tree currently being investigated.
   * @return List of names
   */
  protected Set<String> getSuperInterfacesNames(ClassTree tree) {

    Set<String> superInterfacesNames = new LinkedHashSet<>();
    for (TypeTree typeTree : tree.superInterfaces()) {
      superInterfacesNames.add(typeTree.toString());
    }
    return superInterfacesNames;
  }

  /**
   * Checks if the name of the checked interface matches the reg ex pattern.
   *
   * @param interfaceName Name of the checked interface.
   * @param pattern Regular expression matched with the name of the checked interface.
   * @return True or false.
   */
  protected boolean doesInterfaceHaveRegEx(String interfaceName, Pattern pattern) {

    if (pattern.matcher(interfaceName).matches())
      return true;
    else
      return false;
  }

  /**
   * Checks if one of the super interfaces matches the reg ex pattern.
   *
   * @param superInterfaces List of super interfaces of the checked interface.
   * @param pattern Regular expression matched with the names of the interfaces.
   * @return True or false.
   */
  protected boolean doesSuperInterfaceHaveRegEx(Set<String> superInterfaces, Pattern pattern) {

    for (String superInterface : superInterfaces) {
      if (pattern.matcher(superInterface).matches()) {
        return true;
      }
    }

    return false;
  }

}
