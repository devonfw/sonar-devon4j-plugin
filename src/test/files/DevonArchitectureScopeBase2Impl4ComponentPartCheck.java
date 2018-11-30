/*
 * This is a header...
 */
package io.oasp.ide.sonarqube.component1.logic.base;

import io.oasp.ide.sonarqube.component1.logic.impl.detail.Bar; // Compliant
import io.oasp.ide.sonarqube.component2.logic.impl.Bar; // Noncompliant
import io.oasp.ide.sonarqube.component1.dataaccess.impl.Bar; // Noncompliant

class MyClass {

}