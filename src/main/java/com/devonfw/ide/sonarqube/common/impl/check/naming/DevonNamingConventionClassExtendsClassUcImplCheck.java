package com.devonfw.ide.sonarqube.common.impl.check.naming;

import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that non-abstract classes inherited from AbstractUc are
 * following the devonfw naming convention by beginning with Uc and ending with Impl. They must also implement an
 * interface with the same name except for the suffix Impl.
 */
@Rule(key = "N5", name = "devonfw Naming Check of Use-Case Implementations", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
public class DevonNamingConventionClassExtendsClassUcImplCheck extends DevonNamingConventionClassExtendsClassCheck {

  private static final String DESIRED_SUPERCLASS_NAME = "AbstractUc";

  private List<String> superInterfacesNames;

  /**
   * Calls super constructor to compile the pattern classSuffixRegEx with Uc.*Impl.
   */
  public DevonNamingConventionClassExtendsClassUcImplCheck() {

    super("Uc.*Impl");
  }

  /**
   * Calls super implementation. If no issue was created there, class is not abstract, and it is implementing the
   * correct interface, everything is compliant. Otherwise creates an issue.
   */
  @Override
  protected boolean checkClassNameAndCreateIssue(JavaFileScannerContext context) {

    this.superInterfacesNames = getSuperInterfacesNames();
    String desiredSuperInterfaceName = this.className.replaceAll("Impl$", "");

    if (!super.checkClassNameAndCreateIssue(context) && !isAbstract(this.tree)
        && isImplementingCorrectInterface(desiredSuperInterfaceName)) {
      return false;
    } else {
      context.reportIssue(this, this.tree, "Non-abstract use-case classes must begin with Uc, "
          + "end with Impl and implement an interface with the same name except the suffix Impl.");
      return true;
    }
  }

  /**
   * Checks if the checked class is implementing the needed interface for Impl classes.
   *
   * @param superInterface Regular expression matched with the names of the implemented interfaces.
   * @return True or false.
   */
  protected boolean isImplementingCorrectInterface(String superInterface) {

    for (String name : this.superInterfacesNames) {
      if (superInterface.equals(name)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if the checked class is inheriting from a certain class.
   *
   * @return True or false.
   */
  @Override
  protected boolean isSuperClassMatching() {

    if (DESIRED_SUPERCLASS_NAME.equals(this.superClassName)) {
      return true;
    } else {
      return super.isSuperClassMatching();
    }
  }

}
