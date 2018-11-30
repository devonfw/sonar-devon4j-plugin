/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.component1.logic.impl;

import com.devonfw.ide.sonarqube.component1.logic.base.detail.Foo; // Compliant
import com.devonfw.ide.sonarqube.component2.logic.base.Bar; // Noncompliant
import com.devonfw.ide.sonarqube.component1.dataaccess.base.Some; // Noncompliant
import com.devonfw.module.json.common.base.ObjectMapperFactory; // Compliant

class MyClass {

}