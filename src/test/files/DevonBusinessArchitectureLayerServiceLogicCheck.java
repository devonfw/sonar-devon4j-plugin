
package io.oasp.ide.sonarqube.compA.service.api;

import io.oasp.ide.sonarqube.compB.logic.api.Bar; // Noncompliant
import io.oasp.ide.sonarqube.compB.service.api.Foo; // compliant


class MyClass {

  private Bar bar;

}