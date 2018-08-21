package io.oasp.ide.sonarqube.common.impl;

import org.sonar.api.Plugin;

/***
 * {@link Plugin} that registeres the Devon rules in SonarQube.
 */
public class DevonPlugin implements Plugin {

  @Override
  public void define(Context context) {

    context.addExtension(DevonSonarDefinition.class);
    context.addExtension(DevonSonarRegistrar.class);

    // context.addExtension(PropertyDefinition.builder("DevonArchitectureComponentLayerCheck")
    // .name("Devon Component Layer Check").description("This is the description displayed in web admin console")
    // .category("Java").subCategory("Devon").defaultValue("42").build());

  }

}
