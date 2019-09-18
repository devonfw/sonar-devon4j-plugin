package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.regex.Pattern;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that non-abstract classes extending AbstractDao are
 * following the devonfw naming convention by ending with DaoImpl.
 */
@Rule(key = "Devon4j:N2", name = "Devon naming conventions of inheriting classes (DaoImpl).", //
    description = "Verify that non-abstract Classes extending AbstractDao shall end with DaoImpl. In addition, classes "
        + "that inherit from a class with the suffix Dao must also have Dao as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassDaoCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on DaoImpl classes.
   */
  public DevonNamingConventionClassExtendsClassDaoCheck() {

    super(".*Dao");
  }

  /**
   * Method called after parsing and semantic analysis has been done on file.
   *
   * @param context Context of analysis containing the parsed tree.
   */
  @Override
  public void scanFile(JavaFileScannerContext context) {

    ClassTree tree = getTreeInstance(context);
    this.className = tree.simpleName().name();
    this.superClassName = tree.superClass().toString();

    if (!isDaoImplClass() && !isExtendingAbstractDao())
      return;
    else if (isExtendingAbstractDao() && isDaoImplClass() && !isAbstract(tree))
      return;
    else
      context.addIssueOnFile(this, "Classes of type .*DaoImpl must not be abstract and extend AbstractDao.");
  }

  /**
   * Checks if the checked class is inheriting from AbstractDao
   *
   * @return True or false.
   */
  protected boolean isExtendingAbstractDao() {

    Pattern superClassRegEx = Pattern.compile("AbstractDao");

    if (superClassRegEx.matcher(this.superClassName).matches())
      return true;
    else
      return false;
  }

  /**
   * Checks if the checked class is of type .*DaoImpl.
   *
   * @return True or false.
   */
  protected boolean isDaoImplClass() {

    Pattern classNameRegEx = Pattern.compile(".*DaoImpl");

    if (classNameRegEx.matcher(this.className).matches())
      return true;
    else
      return false;
  }

}
