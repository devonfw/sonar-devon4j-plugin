package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that non-abstract classes extending AbstractDao are
 * following the devonfw naming convention by ending with DaoImpl.
 */
@Rule(key = "Devon4j:N2", name = "Devon naming conventions of inheriting classes (DaoImpl).", //
    description = "Verify that non-abstract Classes extending AbstractDao shall end with DaoImpl. In addition, classes "
        + "that inherit from a class with the suffix Dao must also have Dao as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassDaoCheck extends DevonNamingConventionClassExtendsClassCheck {

  private static final String DESIRED_SUPERCLASS_NAME = "AbstractDao";

  /**
   * Calls super constructor to compile the pattern classSuffiRegEx
   */
  public DevonNamingConventionClassExtendsClassDaoCheck() {

    super(".*DaoImpl");
  }

  /**
  *
  */
  @Override
  protected void checkClassName(JavaFileScannerContext context) {

    super.checkClassName(context);

    if (!isClassNameMatching() && !isSuperClassMatching()) {
      return;
    } else if (isClassNameMatching() && !isAbstract(this.tree) && isSuperClassMatching()) {
      return;
    } else {
      context.addIssueOnFile(this, "DAO implementations must not be abstract and extend AbstractDao.");
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
