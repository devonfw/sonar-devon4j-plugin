/*
 * This is a header...
 */

package io.oasp.ide.sonarqube.compB.logic.api;

import io.oasp.ide.sonarqube.compA.dataaccess.api.Bar; // Noncompliant
import io.oasp.ide.sonarqube.compA.logic.api.Foo; // Noncompliant


class MyClass {

  private Bar bar;

}