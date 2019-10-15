/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.common.api;

import com.devonfw.ide.sonarqube.client.api.Foo; // Noncompliant
import com.devonfw.ide.sonarqube.service.api.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.logic.api.Some; // Noncompliant
import com.devonfw.ide.sonarqube.dataaccess.api.Any; // Noncompliant
import com.devonfw.ide.sonarqube.batch.api.Other; // Noncompliant

class MyClass {
}