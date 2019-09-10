package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.LinkedList;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * {@link DevonNamingConventionClassExtendsClassCheck} verifying that non-abstract classes inherited from AbstractUc are
 * following the devonfw naming convention by beginning with Uc and ending with Impl. They must also implement an
 * interface with the same name except for the suffix Impl.
 */
@Rule(key = "Devon4j:N5", name = "Devon naming conventions of inheriting classes (Uc*Impl)", //
    description = "Verify that non-abstract classes inherited from AbstractUc must begin with Uc and end with Impl. "
        + "Also, the class must implement an interface with the same name except the suffix Impl.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonNamingConventionClassExtendsClassImplCheck extends DevonNamingConventionClassExtendsClassCheck {

  /**
   * Calls the constructor of its base class with the parameters needed for a check on classes extending AbstractUc.
   */
  public DevonNamingConventionClassExtendsClassImplCheck() {

    super("AbstractUc", "Uc.*Impl$", false);
  }

  /**
   * Initializes the list of interfaces implemented by this class.
   */
  public void init() {

    this.interfacesToImplement = new LinkedList<>();
    String interfaceNameToImplement = this.className.replaceAll("Impl", "");
    this.interfacesToImplement.add(interfaceNameToImplement);
  }

}
