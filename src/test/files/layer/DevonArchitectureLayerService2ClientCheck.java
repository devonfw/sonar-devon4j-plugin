/*
 * This is a header...
 */
package com.devonfw.ide.sonarqube.service.api;

import com.devonfw.ide.sonarqube.client.api.Bar; // Noncompliant

class MyClass {

  private com.devonfw.ide.sonarqube.client.api.Foo foo; // Noncompliant

  private Bar bar;

  public com.devonfw.ide.sonarqube.client.api.Foo getFoo() { // Noncompliant
    return this.foo;
  }

  public void init() {

    this.foo = new com.devonfw.ide.sonarqube.client.api.Foo();// Noncompliant
  }
}