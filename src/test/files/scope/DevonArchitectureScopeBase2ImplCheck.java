package com.devonfw.ide.sonarqube.common.base;

import com.devonfw.ide.sonarqube.common.impl.Bar; // Noncompliant

class MyClass {

  private com.devonfw.ide.sonarqube.common.impl.Foo foo; // Noncompliant

  private Bar bar;

  public com.devonfw.ide.sonarqube.common.impl.Foo getFoo() { // Noncompliant
    return this.foo;
  }
  
}