/* This is a header... */
package com.devonfw.ide.sonarqube.compB.logic.api;

import com.devonfw.ide.sonarqube.compA.dataaccess.api.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.compA.logic.api.Foo; // Noncompliant
import com.devonfw.ide.sonarqube.general.service.api.Some; // compliant
import com.google.common.base.Strings; // compliant

class MyClass {

  private Bar bar;
}