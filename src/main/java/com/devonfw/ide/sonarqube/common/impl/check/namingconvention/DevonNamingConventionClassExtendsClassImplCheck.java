package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import java.util.LinkedList;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E10", name = "Devon naming conventions of inheriting classes (Uc*Impl)", //
    description = "Verify that non-abstract classes inherited from AbstractUc must begin with Uc and end with Impl. "
        + "Also, the class must implement an interface with the same name except the suffix Impl.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassImplCheck extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassImplCheck() {

    super("AbstractUc", "Uc.*Impl$", false);
  }

  @Override
  public void init() {

    this.interfacesToImplement = new LinkedList<String>();
    String interfaceNameToImplement = this.className.replaceAll("Impl", "");
    this.interfacesToImplement.add(interfaceNameToImplement);
  }

}
