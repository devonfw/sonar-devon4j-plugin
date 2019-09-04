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

  protected final String extendedInterface;

  protected final String extendingInterfaceSuffix;

  /**
   *
   * The constructor.
   *
   * @param extendedInterface
   * @param extendingInterfaceSuffix
   */
  public DevonNamingConventionInterfaceExtendsInterfaceCheck(String extendedInterface,
      String extendingInterfaceSuffix) {

    this.extendedInterface = extendedInterface;
    this.extendingInterfaceSuffix = extendingInterfaceSuffix;
  }

  @Override
  public void scanFile(JavaFileScannerContext context) {

    Logger logger = Logger.getLogger("logger");

    CompilationUnitTree parsedTree = context.getTree();

    List<Tree> types = parsedTree.types();
    ClassTree tree = getTreeInstance(types);

    String interfaceName = tree.simpleName().name();

    logger.log(Level.INFO, "Name of interface: " + interfaceName);

    if (!tree.kind().equals(Kind.INTERFACE))
      return;

    Set<String> superInterfacesNames = new LinkedHashSet<>();

    for (TypeTree typeTree : tree.superInterfaces()) {
      superInterfacesNames.add(typeTree.toString());
    }

    boolean contains = superInterfacesNames.contains(this.extendedInterface);

    List<String> matchingInterfaces = getMatchingStrings(superInterfacesNames, this.extendingInterfaceSuffix);

    if (contains) {

      Pattern pattern = Pattern.compile(this.extendingInterfaceSuffix);
      Matcher matcher = pattern.matcher(interfaceName);
      boolean endsWith = matcher.matches();

      if (!endsWith) {
        context.addIssueOnFile(this, "Interfaces inheriting from " + this.extendedInterface + " should have "
            + this.extendingInterfaceSuffix + " as prefix");
        return;
      }

    } else if (!matchingInterfaces.isEmpty() && !interfaceName.endsWith(this.extendingInterfaceSuffix)) {
      context.addIssueOnFile(this, "If a superinterface has " + this.extendingInterfaceSuffix
          + " as prefix, then the subinterface should also have " + this.extendingInterfaceSuffix + " as prefix.");
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
