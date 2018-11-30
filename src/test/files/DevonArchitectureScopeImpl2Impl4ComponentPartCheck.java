/*
 * This is a header...
 */
package io.oasp.ide.sonarqube.component1.service.impl;

import io.oasp.ide.sonarqube.component1.service.impl.detail.Bar; // Compliant
import io.oasp.ide.sonarqube.component2.service.impl.Bar; // Noncompliant
import io.oasp.ide.sonarqube.component1.dataaccess.impl.Bar; // Noncompliant
import com.devonfw.module.rest.service.impl.RestServiceExceptionFacade; // Compliant

class MyClass {

}