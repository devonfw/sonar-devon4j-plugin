package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that non-abstract classes extending AbstractDao are
 * following the devonfw naming convention by ending with DaoImpl.
 */
@Rule(key = "N2")
public class DevonNamingConventionClassExtendsClassDaoCheck extends DevonNamingConventionClassExtendsClassCheck {

  private static final String DESIRED_SUPERCLASS_NAME = "AbstractDao";

  /**
   * Calls super constructor to compile the pattern classSuffiRegEx
   */
  public DevonNamingConventionClassExtendsClassDaoCheck() {

    super(".*DaoImpl");
  }

  /**
   * Calls super implementation. If no issue was created there and class is not abstract, everything is compliant.
   * Otherwise creates an issue.
   */
  @Override
  protected boolean checkClassNameAndCreateIssue(JavaFileScannerContext context) {

    if (!super.checkClassNameAndCreateIssue(context) && !isAbstract(this.tree)) {
      return false;
    } else {
      context.reportIssue(this, this.tree, "DAO implementations must not be abstract and extend AbstractDao.");
      return true;
    }
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
