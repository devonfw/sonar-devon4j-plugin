/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.batch.api;

import com.devonfw.ide.sonarqube.service.api.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.service.api.Bar2; // Noncompliant

class MyClass extends AbstractEto { // Noncompliant
}
