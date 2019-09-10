package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.TypeTree;

/**
 * Abstract base class for naming convention checks of interfaces
 */
public abstract class DevonNamingConventionInterfaceExtendsInterfaceCheck implements JavaFileScanner {

  /**
   * If the currently checked interface has this in its super interfaces, rules apply.
   */
  protected final String extendedInterface;

  /**
   * This needs to be the suffix of the checked interface if it extends certain other interfaces.
   */
  protected final String extendingInterfaceSuffix;

  /**
   * The constructor.
   *
   * @param extendedInterface See JavaDoc on variable declaration.
   * @param extendingInterfaceSuffix See JavaDoc on variable declaration.
   */
  public DevonNamingConventionInterfaceExtendsInterfaceCheck(String extendedInterface,
      String extendingInterfaceSuffix) {

    this.extendedInterface = extendedInterface;
    this.extendingInterfaceSuffix = extendingInterfaceSuffix;
  }

  /**
   * Method called after parsing and semantic analysis has been done on file.
   *
   * @param context Context of analysis containing the parsed tree.
   */
  @Override
  public void scanFile(JavaFileScannerContext context) {

    Logger logger = Logger.getLogger("logger");

    CompilationUnitTree parsedTree = context.getTree();

    List<Tree> types = parsedTree.types();
    ClassTree tree = getTreeInstance(types);

    String interfaceName = tree.simpleName().name();
    Set<String> superInterfacesNames = new LinkedHashSet<>();

    logger.log(Level.INFO, "Name of interface: " + interfaceName);

    // If checked file is not an interface, return
    if (!tree.kind().equals(Kind.INTERFACE))
      return;

    // Gets all super interfaces of the checked interface
    for (TypeTree typeTree : tree.superInterfaces()) {
      logger.log(Level.INFO, "Name of super interface: " + typeTree.toString());
      superInterfacesNames.add(typeTree.toString());
    }

    // Checks if one of the super interfaces has 'Repository' as suffix
    List<String> matchingInterfaces = getMatchingStrings(superInterfacesNames, this.extendingInterfaceSuffix);

    if (superInterfacesNames.contains(this.extendedInterface)) {

      Pattern pattern = Pattern.compile(this.extendingInterfaceSuffix);
      Matcher matcher = pattern.matcher(interfaceName);
      boolean endsWith = matcher.find();

      if (!endsWith) {
        context.addIssueOnFile(this, "Interfaces inheriting from " + this.extendedInterface + " should have "
            + this.extendingInterfaceSuffix + " as suffix");
        return;
      }

    } else if (!matchingInterfaces.isEmpty() && !interfaceName.endsWith(this.extendingInterfaceSuffix)) {
      context.addIssueOnFile(this, "If a superinterface has " + this.extendingInterfaceSuffix
          + " as suffix, then the subinterface should also have " + this.extendingInterfaceSuffix + " as suffix");
      return;
    }

  }

  private static ClassTree getTreeInstance(List<Tree> types) {

    for (Tree tree : types) {
      if (tree instanceof ClassTree) {
        return (ClassTree) tree;
      }
    }

    return null;
  }

  List<String> getMatchingStrings(Set<String> list, String regex) {

    List<String> matches = new ArrayList<>();

    Pattern pattern = Pattern.compile(regex);

    for (String string : list) {
      if (pattern.matcher(string).matches()) {
        matches.add(string);
      }
    }

    return matches;
  }

}
