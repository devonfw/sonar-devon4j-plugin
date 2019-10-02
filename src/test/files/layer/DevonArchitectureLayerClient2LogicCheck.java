/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.client.api;

import com.devonfw.ide.sonarqube.logic.api.Bar; // Noncompliant

class MyClass {

  private com.devonfw.ide.sonarqube.logic.api.Foo foo; // Noncompliant

  private Bar bar;

  public com.devonfw.ide.sonarqube.logic.api.Foo getFoo() { // Noncompliant
    return this.foo;
  }

  public void init() {

    this.foo = new com.devonfw.ide.logic.api.Foo();// Noncompliant
  }
}