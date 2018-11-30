/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.compA.dataaccess.base;

import com.devonfw.ide.sonarqube.compB.dataaccess.api.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.compA.dataaccess.api.Foo; // compliant
import com.devonfw.module.jpa.dataaccess.base.AbstractDao; // compliant
import com.devonfw.module.jpa.dataaccess.api.data.GenericRepository; // compliant

class MyClass {

  private Bar bar;

  public static class NestedClass {

  }

}