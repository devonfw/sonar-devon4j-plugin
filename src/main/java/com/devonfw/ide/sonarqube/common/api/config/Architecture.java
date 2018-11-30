package com.devonfw.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * {@link Architecture} of a devonfw application.
 *
 * @see #getComponents()
 */
public class Architecture {

  private Boolean transitive;

  private List<Component> components;

  private Map<String, Component> componentMap;

  /**
   * The constructor.
   */
  public Architecture() {

    super();
  }

  /**
   * @return {@code true} or {@code null} if the {@link Component#getDependencies() dependencies} are treated
   *         transitive, {@code false} otherwise.
   */
  public Boolean getTransitive() {

    return this.transitive;
  }

  /**
   * @param transitive new value of {@link #getTransitive()}.
   */
  public void setTransitive(Boolean transitive) {

    this.transitive = transitive;
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
    if (!this.componentMap.containsKey(Component.NAME_GENERAL)) {
      Component general = new Component(Component.NAME_GENERAL);
      this.componentMap.put(Component.NAME_GENERAL, general);
    }
    Node<String> root = new Node<>("components");
    Component app = this.componentMap.get(Component.NAME_APP);
    if (app == null) {
      app = new Component(Component.NAME_APP);
      this.componentMap.put(Component.NAME_APP, app);
    }
    app.transitiveDependencies = new HashSet<>();
    for (Component component : this.components) {
      initialize(component, root, configuration);
      app.transitiveDependencies.add(component.getName());
    }
  }

  private void initialize(Component component, Node<String> parentNode, Configuration configuration) {

    String name = component.getName();
    Node<String> componentNode = parentNode.createChild(name);
    if (component.transitiveDependencies != null) {
      Node<String> duplicate = parentNode.find(name);
      if (duplicate != null) {
        configuration.status().addError("Cyclic dependency detected: " + componentNode);
      }
      return; // already initialized...
    }
    component.transitiveDependencies = new HashSet<>(component.getDependencies());
    if (!name.equals(Component.NAME_GENERAL)) {
      component.transitiveDependencies.add(Component.NAME_GENERAL);
    }
    for (String dependency : component.getDependencies()) {
      if (!dependency.contains(".")) {
        Component dependentComponent = this.componentMap.get(dependency);
        if (dependentComponent == null) {
          configuration.status().addError(
              "Component '" + name + "' has dependency '" + dependency + "' but no such component is defined.");
        } else {
          initialize(dependentComponent, componentNode, configuration);
          if (hasTransitiveDependencies()) {
            component.transitiveDependencies.addAll(dependentComponent.transitiveDependencies);
          }
        }
      }
    }
  }

  /**
   * @return {@code true} if {@link Component#getDependencies() dependencies} are {@link #getTransitive() transitive}
   *         (default), {@code false} otherwise.
   */
  public boolean hasTransitiveDependencies() {

    return !Boolean.FALSE.equals(this.transitive);
  }

}
