/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.compA.logic.api;

import com.devonfw.ide.sonarqube.compB.dataaccess.api.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.compB.logic.api.Foo; // compliant
import com.devonfw.module.jpa.dataaccess.api.RevisionMetadata; // compliant (build in exclusion)

class MyClass {

  private Bar bar;

}