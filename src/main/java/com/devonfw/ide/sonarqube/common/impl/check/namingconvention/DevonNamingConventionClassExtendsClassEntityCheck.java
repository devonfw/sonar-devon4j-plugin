package com.devonfw.ide.sonarqube.common.impl.check.namingconvention;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

@Rule(key = "Devon4j:E8", name = "Devon Naming Convention Check", //
    description = "Classes implementing PersistenceEntity (extending ApplicationPersistenceEntity) shall end with Entity.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonNamingConventionClassExtendsClassEntityCheck extends DevonNamingConventionClassExtendsClassCheck {

  public DevonNamingConventionClassExtendsClassEntityCheck() {

    super("ApplicationPersistenceEntity", "Entity$\"", false);
  }

}