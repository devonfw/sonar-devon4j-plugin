package com.devonfw.ide.sonarqube.dataaccess.api;

import javax.persistence.Entity; // compliant
import javax.persistence.Table; // compliant

@Entity
@Table(name="Foo")
class FooEntity {
}