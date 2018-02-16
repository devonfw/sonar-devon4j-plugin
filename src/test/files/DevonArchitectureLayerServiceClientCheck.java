/*
 * This is a header...
 */
package io.oasp.ide.sonarqube.service.api;

import io.oasp.ide.sonarqube.client.api.Bar; // Noncompliant

class MyClass {

  private io.oasp.ide.sonarqube.client.api.Foo foo; // Noncompliant

  private Bar bar;

  public io.oasp.ide.sonarqube.client.api.Foo getFoo() { // Noncompliant
    return this.foo;
  }

  public void init() {

    this.foo = new io.oasp.ide.sonarqube.client.api.Foo();// Noncompliant
  }
}