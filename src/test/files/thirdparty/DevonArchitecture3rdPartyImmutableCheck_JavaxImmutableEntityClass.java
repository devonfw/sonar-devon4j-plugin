package com.devonfw.ide.sonarqube.dataaccess.impl;

import javax.persistence.Entity; // compliant
import javax.annotation.concurrent.Immutable; // Noncompliant

@Entity
class FooEntity{
}