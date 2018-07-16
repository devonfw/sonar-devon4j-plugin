package io.oasp.ide.sonarqube.common.impl;

import java.util.List;

import org.sonar.check.RuleProperty;

import io.oasp.ide.sonarqube.common.api.config.Component;
import io.oasp.ide.sonarqube.common.api.config.Config;
import io.oasp.ide.sonarqube.common.impl.config.ConfigMapper;
import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */
public abstract class DevonBusinessArchitectureCheck extends DevonArchitectureCheck {

  @RuleProperty(key = DevonSonarPlugin.CONFIG_KEY)
  String configJson = "";

  private static Config config;

  protected Config getConfig() {

    if (config == null) {
      ConfigMapper mapper = new ConfigMapper();
      config = mapper.fromJson(this.configJson);
    }
    return config;
  }

  protected Component getComponent(String name) {

    List<Component> components = getConfig().getBusinessArchitecture().getComponents();
    for (Component component : components) {
      if (component.getName().equals(name)) {
        return component;
      }
    }
    return null;
  }

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    String sourceComponentName = source.getComponent();
    String targetComponentName = target.getComponent();
    if (sourceComponentName.equals(targetComponentName)) {
      return null;
    }
    if (!source.getRoot().equals(target.getRoot())) {
      // TODO access to other applications or libraries not yet handled
      return null;
    }
    Component sourceComponent = getComponent(sourceComponentName);
    if (sourceComponent == null) {
      return sourceComponentUndefined(sourceComponentName);
    }
    boolean targetDependencyAllowed = sourceComponent.hasDependency(targetComponentName);
    if (!targetDependencyAllowed) {
      return targetDependencyNotAllowed(sourceComponent, targetComponentName);
    } else {
      return checkDependency(source, sourceComponent, target, targetTypeSimpleName);
    }
  }

  protected String sourceComponentUndefined(String sourceComponentName) {

    return null;
  }

  /**
   * @param sourceComponent
   * @param targetComponentName
   * @return
   */
  protected String targetDependencyNotAllowed(Component sourceComponent, String targetComponentName) {

    return null;
  }

  /**
   * @param source
   * @param sourceComponent
   * @param target
   * @param targetTypeSimpleName
   * @return
   */
  protected abstract String checkDependency(OaspPackage source, Component sourceComponent, OaspPackage target,
      String targetTypeSimpleName);
}
