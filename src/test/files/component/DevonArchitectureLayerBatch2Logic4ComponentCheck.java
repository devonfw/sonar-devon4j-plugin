/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.compA.batch.api;

import com.devonfw.ide.sonarqube.compB.logic.api.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.compB.batch.api.Foo; // compliant
import com.devonfw.ide.sonarqube.compA.logic.api.Some; // compliant

class MyClass {

  private Bar bar;

}