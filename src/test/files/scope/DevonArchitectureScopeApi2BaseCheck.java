package com.devonfw.ide.sonarqube.common.api;

import com.devonfw.ide.sonarqube.common.base.Bar; // Noncompliant

class MyClass {

  private com.devonfw.ide.sonarqube.common.base.Foo foo; // Noncompliant

  private Bar bar;

  public com.devonfw.ide.sonarqube.common.base.Foo getFoo() { // Noncompliant
    return this.foo;
  }

  public void init() {

    this.foo = new com.devonfw.ide.sonarqube.common.base.Foo();// Noncompliant
  }

}