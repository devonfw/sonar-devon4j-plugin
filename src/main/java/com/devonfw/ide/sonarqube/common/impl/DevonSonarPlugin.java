package com.devonfw.ide.sonarqube.common.impl;

import org.sonar.api.Plugin;
import org.sonar.api.PropertyType;
import org.sonar.api.config.PropertyDefinition;

/**
 * The {@link Plugin} to integrate devonfw architecture rules into SonarQube.
 */
public class DevonSonarPlugin implements Plugin {

  public static final String CONFIG_KEY = "sonar.devon.config";

  static final String FORBIDDEN_CONF_KEY = "sonar.devon.forbiddenConf";

  static final String DISABLED = "Disabled";

  static final String ISSUES_SEVERITY_KEY = "sonar.Devon.preview.issuesSeverity";

  @Override
  public void define(Context context) {

    context.addExtensions(DevonSonarDefinition.class, DevonSonarRegistrar.class);
    context.addExtension(PropertyDefinition.builder(CONFIG_KEY).name("Config JSON")
        .description("Configuration of business architecture, etc. TODO").category("Devon").subCategory("")
        .type(PropertyType.TEXT)
        .defaultValue(
            "{\"businessArchitecture\":{\"components\":[\n{\"name\":\"component1\",\\\"dependencies\\\":[]}}\n]}}")
        .build());
    // context.addExtension(PropertyDefinition.builder(CONFIG_KEY).name("Config JSON")
    // .description("Employee personal information").category("Yassin").subCategory("").type(PropertyType.TEXT)
    // .defaultValue("{\"Company\":{\"employee\":[\n{\"name\":\"name1\",\\\"working days\\\":[]}}\n]}}").build());
  }
}
