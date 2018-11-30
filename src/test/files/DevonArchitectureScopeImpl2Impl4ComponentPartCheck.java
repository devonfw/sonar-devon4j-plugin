/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.component1.service.impl;

import com.devonfw.ide.sonarqube.component1.service.impl.detail.Foo; // Compliant
import com.devonfw.ide.sonarqube.component2.service.impl.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.component1.dataaccess.impl.Some; // Noncompliant
import com.devonfw.module.rest.service.impl.RestServiceExceptionFacade; // Compliant

class MyClass {

}