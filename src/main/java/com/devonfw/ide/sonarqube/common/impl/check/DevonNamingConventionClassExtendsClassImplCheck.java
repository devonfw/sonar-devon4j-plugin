package com.devonfw.ide.sonarqube.common.impl.check;

import java.util.LinkedList;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

/**
 * @author vhacimuf
 *
 */

@Rule(key = "Devon4j:S2", name = "Devon Naming Convention Check", //
    description = "Verify that (Non-Abstract) Classes extending AbstractUc shall start with Uc and end with Impl "
        + "(also they should implement an interface with the same name except the suffix Impl.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassImplCheck extends DevonNamingConventionClassExtendsClassCheck {

  @Override
  public void init() {

    this.extendedSuperClass = "AbstractUc";
    this.classSuffixRegEx = "Uc.*Impl$";
    this.isAbstract = false;
    this.interfacesToImplement = new LinkedList<String>();
    String interfaceNameToImplement = this.className.replaceAll("Impl", "");

    this.interfacesToImplement.add(interfaceNameToImplement);

  }

}
