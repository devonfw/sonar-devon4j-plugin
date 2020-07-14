package com.devonfw.ide.sonarqube.common.api;

import javax.persistence.Entity; // compliant
import javax.persistence.Table; // compliant

@Entity
@Table(name="Foo")
public class EmbeddableFoo {
}