package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

  /**
   * If the currently checked class extends this class, rules apply
   */
  protected final String extendedSuperClass;

  /**
   * This needs to be the suffix of the checked class if it extends a certain other class.
   */
  protected final String classSuffixRegEx;

  /**
   * Should the checked class be abstract or not?
   */
  protected final boolean isAbstract;

  /**
   * Name of the checked class
   */
  protected String className;

  /**
   * Interfaces implemented by the checked class
   */
  protected List<String> interfacesToImplement;

  /**
   *
   * The constructor.
   *
   * @param extendedSuperClass See JavaDoc on variable declaration.
   * @param classSuffixRegEx See JavaDoc on variable declaration.
   * @param isAbstract See JavaDoc on variable declaration.
   */
  public DevonNamingConventionClassExtendsClassCheck(String extendedSuperClass, String classSuffixRegEx,
      boolean isAbstract) {

    this.extendedSuperClass = extendedSuperClass;
    this.classSuffixRegEx = classSuffixRegEx;
    this.isAbstract = isAbstract;
  }

  /**
   *
   * The constructor.
   *
   * @param extendedSuperClass See JavaDoc on variable declaration.
   * @param classSuffixRegEx See JavaDoc on variable declaration.
   */
  public DevonNamingConventionClassExtendsClassCheck(String extendedSuperClass, String classSuffixRegEx) {

    this.extendedSuperClass = extendedSuperClass;
    this.classSuffixRegEx = classSuffixRegEx;
    this.isAbstract = true; // Temporary Solution! There is no UC where a true value for isAbstract changes the flow of
                            // this check.
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

    this.className = tree.simpleName().name();
    String superClassName = "DEFAULT";
    Set<String> superInterfacesNames = new LinkedHashSet<>();

    Pattern pattern = Pattern.compile(this.classSuffixRegEx);

    init();

    for (TypeTree typeTree : tree.superInterfaces()) {
      superInterfacesNames.add(typeTree.toString());
      logger.log(Level.INFO, "Name of implemented interface: " + typeTree.toString());
    }

    try {
      superClassName = tree.superClass().toString();
    } catch (NullPointerException ex) {
    }

    logger.log(Level.INFO, "Name of super class: " + superClassName);
    logger.log(Level.INFO, "Name of class: " + this.className);
    logger.log(Level.INFO, "Class Suffix: " + this.classSuffixRegEx);

    // Return if no super class or if checked file is not a class
    if (superClassName.equals("DEFAULT") || !tree.kind().equals(Kind.CLASS))
      return;

    logger.log(Level.INFO, "STILL RUNNING");

    if (superClassName.equals(this.extendedSuperClass)) {

      if (pattern.matcher(this.className).find()) {
        context.addIssueOnFile(this, "Classes inheriting from " + this.extendedSuperClass + " should have "
            + this.classSuffixRegEx + " as suffix");
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
    } else if (pattern.matcher(superClassName).find()) {

      if (!pattern.matcher(this.className).find()) {
        context.addIssueOnFile(this, "If a superclass has " + this.classSuffixRegEx
            + " as suffix, then the subclass should also have " + this.classSuffixRegEx + " as suffix");
        return;

      }
    }

    if (!this.isAbstract) {
      if (isAbstract(tree)) {
        context.addIssueOnFile(this, "Classes inheriting from " + this.extendedSuperClass + " should not be abstract");
        return;
      }
    }

  }

  /**
   * Only needed for check on Impl classes. See {@link DevonNamingConventionClassExtendsClassImplCheck} for JavaDoc.
   */
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
