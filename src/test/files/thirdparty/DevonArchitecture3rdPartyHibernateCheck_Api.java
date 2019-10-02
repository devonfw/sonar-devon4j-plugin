package com.devonfw.ide.sonarqube.dataaccess.api;

import org.hibernate.Session; // Noncompliant
import org.hibernate.annotations.Entity; // Noncompliant
import org.hibernate.annotations.OrderBy; // Noncompliant
import org.hibernate.annotations.Cascade; // Noncompliant
import org.hibernate.annotations.FilterDef; // compliant

class MyClass {
}