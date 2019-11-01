/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.client.api;

import com.devonfw.ide.sonarqube.batch.api.Bar; // Noncompliant

class MyClass {

  private com.devonfw.ide.sonarqube.batch.api.Foo foo; // Noncompliant

  private Bar bar;

  public com.devonfw.ide.sonarqube.batch.api.Foo getFoo() { // Noncompliant
    return this.foo;
  }

}