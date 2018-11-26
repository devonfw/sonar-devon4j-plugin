package com.devonfw.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Architecture} of a devonfw application.
 *
 * @see #getComponents()
 */
public class Architecture {

  private List<Component> components;

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

    for (Component component : getComponents()) {
      if (component.getName().equals(name)) {
        return component;
      }
    }
    for (Component component : Component.DEFAULT_COMPONENTS) {
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

}
