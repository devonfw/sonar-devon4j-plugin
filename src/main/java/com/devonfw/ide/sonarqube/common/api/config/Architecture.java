package com.devonfw.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * {@link Architecture} of a devonfw application.
 *
 * @see #getComponents()
 */
public class Architecture {

  private List<Component> components;

  private Map<String, Component> componentMap;

  /**
   * The constructor.
   */
  public Architecture() {

    super();
  }

  /**
   * @return components
   */
  public List<Component> getComponents() {

    if (this.components == null) {
      this.components = new ArrayList<>();
    }
    return this.components;
  }

  /**
   * @param name the {@link Component#getName() name} of the requested {@link Component}.
   * @return the requested {@link Component} or {@code null} if no such {@link Component} exists.
   */
  public Component getComponent(String name) {

    if (this.componentMap != null) {
      return this.componentMap.get(name);
    }
    for (Component component : getComponents()) {
      if (component.getName().equals(name)) {
        return component;
      }
    }
    return null;
  }

  /**
   * @param components new value of {@link #getComponents()}.
   */
  public void setComponents(List<Component> components) {

    this.components = components;
  }

  void initialize(Configuration configuration) {

    this.componentMap = new HashMap<>();
    for (Component component : this.components) {
      Component duplicate = this.componentMap.put(component.getName(), component);
      if (duplicate != null) {
        configuration.status().addError("Duplicate architecture component '" + component.getName() + "'.");
      }
    }
    Component general = this.componentMap.get(Component.NAME_GENERAL);
    if (general == null) {
      general = new Component(Component.NAME_GENERAL);
      this.componentMap.put(Component.NAME_GENERAL, general);
    }
    Node<String> root = new Node<>("components");
    Component app = this.componentMap.get(Component.NAME_APP);
    if (app == null) {
      app = new Component(Component.NAME_APP);
      this.componentMap.put(Component.NAME_APP, app);
    }
    app.allDependencies = new HashSet<>();
    for (Component component : this.components) {
      initialize(component, root, configuration);
      app.allDependencies.add(component.getName());
    }
    for (Component component : this.components) {
      Set<String> nonTransitiveDependencies = component.getNonTransitiveDependencies();
      if (nonTransitiveDependencies != null) {
        component.allDependencies.addAll(nonTransitiveDependencies);
      }
    }
  }

  private void initialize(Component component, Node<String> parentNode, Configuration configuration) {

    String name = component.getName();
    Node<String> componentNode = parentNode.createChild(name);
    if (component.allDependencies != null) {
      Node<String> duplicate = parentNode.find(name);
      if (duplicate != null) {
        configuration.status().addError("Cyclic dependency detected: " + componentNode);
      }
      return; // already initialized...
    }
    component.allDependencies = new HashSet<>(component.getDependencies());
    if (!name.equals(Component.NAME_GENERAL)) {
      component.allDependencies.add(Component.NAME_GENERAL);
    }
    for (String dependency : component.getDependencies()) {
      if (dependency.contains(".")) {
        component.allDependencies.add(dependency);
      } else {
        Component dependentComponent = this.componentMap.get(dependency);
        if (dependentComponent == null) {
          configuration.status().addError(
              "Component '" + name + "' has dependency '" + dependency + "' but no such component is defined.");
        } else {
          initialize(dependentComponent, componentNode, configuration);
          component.allDependencies.addAll(dependentComponent.allDependencies);
        }
      }
    }
  }

}
