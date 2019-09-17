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
        + "that inherit from a class with the suffix DaoImpl must also have DaoImpl as their suffix.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassDaoCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on DaoImpl classes.
   */
  public DevonNamingConventionClassExtendsClassDaoCheck() {

    super(".*Dao");
    // super(null) ???
  }

  // super("AbstractDao", ".*DaoImpl"); <---- original super constructor

  /**
   * Classes of type DaoImpl must not be abstract.
   */
  @Override
  public void scanFile(JavaFileScannerContext context) {

  }

}
