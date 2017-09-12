package io.oasp.ide.sonarqube.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.Plugin;

/**
 * {@link Plugin} that registeres the Devon rules in SonarQube.
 */
public class DevonPlugin implements Plugin {

  @Override
  public void define(Context context) {

    List<Object> extensions = new ArrayList<>();
    extensions.add(new ArchitectureRule());
    context.addExtensions(extensions);
  }

}
