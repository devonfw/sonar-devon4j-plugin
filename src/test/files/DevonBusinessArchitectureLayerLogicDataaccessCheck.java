/*
 * This is a header...
 */

package io.oasp.ide.sonarqube.compA.logic.api;

import io.oasp.ide.sonarqube.compB.dataaccess.api.Bar; // Noncompliant
import io.oasp.ide.sonarqube.compB.logic.api.Foo; // compliant


class MyClass {

  private Bar bar;

}