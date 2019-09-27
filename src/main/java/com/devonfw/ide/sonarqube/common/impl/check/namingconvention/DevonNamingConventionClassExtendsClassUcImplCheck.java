package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that non-abstract classes inherited from AbstractUc are
 * following the devonfw naming convention by beginning with Uc and ending with Impl. They must also implement an
 * interface with the same name except for the suffix Impl.
 */
@Rule(key = "Devon4j:N5", name = "Devon naming conventions of inheriting classes (Uc.*Impl)", //
    description = "Verify that non-abstract classes inherited from AbstractUc must begin with Uc and end with Impl. "
        + "Also, the class must implement an interface with the same name except the suffix Impl.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
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
   *
   */
  @Override
  protected void checkClassName(JavaFileScannerContext context) {

    super.checkClassName(context);

    this.superInterfacesNames = getSuperInterfacesNames();
    String desiredSuperInterfaceName = this.className.replaceAll("Impl$", "");

    if (!isClassNameMatching() && !isSuperClassMatching()) {
      return;
    } else if (isClassNameMatching() && !isAbstract(this.tree) && isSuperClassMatching()
        && isImplementingCorrectInterface(desiredSuperInterfaceName)) {
      return;
    } else {
      context.addIssueOnFile(this, "Non-abstract use-case classes must begin with Uc, "
          + "end with Impl and implement an interface with the same name except the suffix Impl.");
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
      } else {
        return false;
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
