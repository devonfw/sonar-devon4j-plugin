/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.component1.logic.base;

import com.devonfw.ide.sonarqube.component1.logic.impl.detail.Foo; // Compliant
import com.devonfw.ide.sonarqube.component2.logic.impl.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.component1.dataaccess.impl.Some; // Noncompliant

class MyClass {

}