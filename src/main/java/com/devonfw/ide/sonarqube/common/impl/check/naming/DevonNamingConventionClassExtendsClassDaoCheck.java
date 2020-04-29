package com.devonfw.ide.sonarqube.common.impl.check.naming;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that non-abstract classes extending AbstractDao are
 * following the devonfw naming convention by ending with DaoImpl.
 */
@Rule(key = "N2", name = "devonfw Naming Check of DAO Implementations", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "naming" })
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
  protected boolean checkClassNameAndCreateIssue(ClassTree tree, JavaFileScannerContext context) {

    if (!super.checkClassNameAndCreateIssue(tree, context) && !isAbstract(tree)) {
      return false;
    } else {
      context.addIssue(tree.openBraceToken().line(), this,
          "DAO implementations must not be abstract and extend AbstractDao.");
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

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

}
