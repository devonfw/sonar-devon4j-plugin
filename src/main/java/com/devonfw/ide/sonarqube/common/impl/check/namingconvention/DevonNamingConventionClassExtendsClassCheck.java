package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sonar.java.model.ModifiersUtils;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.Modifier;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.TypeTree;

/**
 * Abstract base class for naming convention checks of classes
 */
public abstract class DevonNamingConventionClassExtendsClassCheck implements JavaFileScanner {

  protected final String extendedSuperClass;

  protected final String classSuffixRegEx;

  protected final Boolean isAbstract;

  protected String className;

  protected List<String> interfacesToImplement;

  /**
   *
   * The constructor.
   *
   * @param extendedSuperClass
   * @param classSuffixRegEx
   * @param isAbstract
   */
  public DevonNamingConventionClassExtendsClassCheck(String extendedSuperClass, String classSuffixRegEx,
      Boolean isAbstract) {

    this.extendedSuperClass = extendedSuperClass;
    this.classSuffixRegEx = classSuffixRegEx;
    this.isAbstract = isAbstract;
  }

  /**
   *
   * The constructor.
   *
   * @param extendedSuperClass
   * @param classSuffixRegEx
   */
  public DevonNamingConventionClassExtendsClassCheck(String extendedSuperClass, String classSuffixRegEx) {

    this.extendedSuperClass = extendedSuperClass;
    this.classSuffixRegEx = classSuffixRegEx;
    this.isAbstract = null;
  }

  @Override
  public void scanFile(JavaFileScannerContext context) {

    Logger logger = Logger.getLogger("logger");

    CompilationUnitTree parsedTree = context.getTree();

    List<Tree> types = parsedTree.types();
    ClassTree tree = getTreeInstance(types);

    this.className = tree.simpleName().name();
    String superClassName = "DEFAULT";
    Set<String> superInterfacesNames = new LinkedHashSet<>();

    init();

    for (TypeTree typeTree : tree.superInterfaces()) {
      superInterfacesNames.add(typeTree.toString());
    }

    try {
      superClassName = tree.superClass().toString();
    } catch (NullPointerException ex) {
    }

    logger.log(Level.INFO, "Name of super class: " + superClassName);
    logger.log(Level.INFO, "Name of class: " + this.className);

    if (superClassName.equals("DEFAULT") || !tree.kind().equals(Kind.CLASS))
      return;

    logger.log(Level.INFO, "STILL RUNNING");

    if (superClassName.equals(this.extendedSuperClass)) {

      Pattern pattern = Pattern.compile(this.classSuffixRegEx);
      Matcher matcher = pattern.matcher(this.className);
      boolean endsWith = matcher.find();

      if (!endsWith) {
        context.addIssueOnFile(this, "Classes inheriting from " + this.extendedSuperClass + " should have "
            + this.classSuffixRegEx + " as prefix");
        return;
      }

      if (this.interfacesToImplement != null) {
        boolean contains = superInterfacesNames.containsAll(this.interfacesToImplement);

        if (!contains) {
          context.addIssueOnFile(this, "Classes extending " + this.extendedSuperClass
              + " should implement an interface with the same name except the suffix");
          return;

        }
      }
    } else if (Pattern.compile(this.classSuffixRegEx).matcher(superClassName).find()) {

      if (!Pattern.compile(this.classSuffixRegEx).matcher(this.className).find()) {
        context.addIssueOnFile(this, "If a superclass has " + this.classSuffixRegEx
            + " as prefix, then the subclass should also have " + this.classSuffixRegEx + " as prefix.");
        return;

      }
    }
    boolean isAbstract = isAbstract(tree);

    if (this.isAbstract != null)
      if (this.isAbstract) {
        if (!isAbstract) {

          context.addIssueOnFile(this, "Classes inheriting from " + this.extendedSuperClass + " should be abstract");
          return;
        }
      } else {
        if (!this.isAbstract) {
          if (isAbstract) {
            context.addIssueOnFile(this,
                "Classes inheriting from " + this.extendedSuperClass + " should not be abstract");
            return;
          }
        }

      }

  }

  protected void init() {

    return;
  }

  private static ClassTree getTreeInstance(List<Tree> types) {

    for (Tree tree : types) {
      if (tree instanceof ClassTree) {
        return (ClassTree) tree;
      }
    }
    return null;
  }

  private static boolean isAbstract(ClassTree tree) {

    return ModifiersUtils.hasModifier(tree.modifiers(), Modifier.ABSTRACT);
  }

}
