
package com.devonfw.ide.sonarqube.compA.service.api;

import com.devonfw.ide.sonarqube.compB.logic.api.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.compB.service.api.Foo; // compliant

class MyClass {

  private Bar bar;

}