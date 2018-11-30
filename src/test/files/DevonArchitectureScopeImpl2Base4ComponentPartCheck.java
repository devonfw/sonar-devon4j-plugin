/*
 * This is a header...
 */
package io.oasp.ide.sonarqube.component1.logic.impl;

import io.oasp.ide.sonarqube.component1.logic.base.detail.Foo; // Compliant
import io.oasp.ide.sonarqube.component2.logic.base.Bar; // Noncompliant
import io.oasp.ide.sonarqube.component1.dataaccess.base.Some; // Noncompliant
import com.devonfw.module.json.common.base.ObjectMapperFactory; // Compliant

class MyClass {

}