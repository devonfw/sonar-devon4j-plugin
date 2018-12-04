package com.devonfw.ide.sonarqube.logic.impl;

import org.springframework.transaction.annotation.Transactional; // Noncompliant
import javax.transaction.Transactional; // compliant

class MyClass {
}