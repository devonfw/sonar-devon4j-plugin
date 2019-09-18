package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that non-abstract classes inherited from AbstractUc are
 * following the devonfw naming convention by beginning with Uc and ending with Impl. They must also implement an
 * interface with the same name except for the suffix Impl.
 */
@Rule(key = "Devon4j:N5", name = "Devon naming conventions of inheriting classes (Uc.*Impl)", //
    description = "Verify that non-abstract classes inherited from AbstractUc must begin with Uc and end with Impl. "
        + "Also, the class must implement an interface with the same name except the suffix Impl.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassImplCheck extends DevonNamingConventionClassExtendsClassCheck {

  private List<String> superInterfacesNames;

  /**
   * Calls super constructor to set final field classSuffixRegEx with Uc.*Impl.
   */
  public DevonNamingConventionClassExtendsClassImplCheck() {

    super("Uc.*Impl");
  }

  /**
   * Method called after parsing and semantic analysis has been done on file.
   *
   * @param context Context of analysis containing the parsed tree.
   */
  @Override
  public void scanFile(JavaFileScannerContext context) {

    Logger logger = Logger.getLogger("logger");

    ClassTree tree = getTreeInstance(context);
    this.className = tree.simpleName().name();
    this.superClassName = getNameOfSuperClass(tree);
    this.superInterfacesNames = getSuperInterfacesNames(tree);

    Pattern superInterfaceRegEx = Pattern.compile(tree.simpleName().name().replaceAll("Impl$", ""));
    logger.log(Level.INFO, "superInterfaceRegEx: " + superInterfaceRegEx.toString());

    if (!isUcImplClass() && !isExtendingAbstractUc())
      return;
    else if (isUcImplClass() && !isAbstract(tree) && isExtendingAbstractUc()
        && isImplementingCorrectInterface(superInterfaceRegEx))
      return;
    else
      context.addIssueOnFile(this, "Non-abstract classes inheriting from AbstractUc must begin with Uc, "
          + "end with Impl and implement an interface with the same name except the suffix Impl.");
  }

  /**
   * Checks if the checked class is inheriting from AbstractUc.
   *
   * @return True or false.
   */
  protected boolean isExtendingAbstractUc() {

    Pattern superClassRegEx = Pattern.compile("AbstractUc");

    if (superClassRegEx.matcher(this.superClassName).matches())
      return true;
    else
      return false;
  }

  /**
   * Checks if the checked class is implementing the needed interface for Impl classes.
   *
   * @param superInterfaceRegEx Regular expression matched with the names of the implemented interfaces.
   * @return True or false.
   */
  protected boolean isImplementingCorrectInterface(Pattern superInterfaceRegEx) {

    for (String name : this.superInterfacesNames) {
      if (superInterfaceRegEx.matcher(name).matches())
        return true;
      else
        return false;
    }
    return false;
  }

  /**
   * Checks if the checked class is a Uc.*Impl class.
   *
   * @return True or false.
   */
  protected boolean isUcImplClass() {

    Pattern classNameRegEx = Pattern.compile(this.classSuffixRegEx);

    if (classNameRegEx.matcher(this.className).matches())
      return true;
    else
      return false;
  }

}
