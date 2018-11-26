package com.devonfw.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * {@link Component} of the {@link Architecture}.
 *
 * @see com.devonfw.module.basic.common.api.reflect.Devon4jPackage#getComponent()
 */
public class Component {

  static final Component GENERAL = new Component("general", Collections.emptyList());

  static final Component APP = new Component("app", Collections.emptyList());

  static final Component APPLICATION = new Component("application", Collections.emptyList());

  static final List<Component> DEFAULT_COMPONENTS = Collections
      .unmodifiableList(Arrays.asList(GENERAL, APP, APPLICATION));

  private String name;

  private List<String> dependencies;

  /**
   * The constructor.
   */
  public Component() {

    super();
  }

  /**
   * The constructor.
   *
   * @param name the {@link #getName() name} of this {@link Component}.
   */
  public Component(String name) {

    super();
    this.name = name;
  }

  /**
   * The constructor.
   *
   * @param name the {@link #getName() name} of this {@link Component}.
   * @param dependencies the {@link #getDependencies() dependencies}.
   */
  public Component(String name, List<String> dependencies) {

    super();
    this.name = name;
    this.dependencies = dependencies;
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getName()}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return dependencies
   */
  public List<String> getDependencies() {

    if (this.dependencies == null) {
      this.dependencies = new ArrayList<>();
    }
    return this.dependencies;
  }

  /**
   * @param dependencies new value of {@link #getDependencies()}.
   */
  public void setDependencies(List<String> dependencies) {

    if (this.dependencies != null) {
      throw new IllegalStateException();
    }
    this.dependencies = dependencies;
  }

  /**
   * @param dependentComponentName the {@link #getName() name} of the dependent {@link Component}.
   * @return {@code true} if this {@link Component} has a {@link #getDependencies() defined dependency} on the
   *         {@link Component} with the given {@link #getName() name}, {@code false} otherwise.
   */
  public boolean hasDependency(String dependentComponentName) {

    if ((this == APP) || (this == APPLICATION)) {
      return true;
    }
    if (dependentComponentName.equals(GENERAL.name)) {
      return true;
    }
    for (String dependency : getDependencies()) {
      if (dependency.equals(dependentComponentName)) {
        return true;
      }
    }
    return false;
  }

}
