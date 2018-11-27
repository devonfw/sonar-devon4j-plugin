package com.devonfw.ide.sonarqube.common.api.config;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link Component} of the {@link Architecture}.
 *
 * @see com.devonfw.module.basic.common.api.reflect.Devon4jPackage#getComponent()
 */
public class Component {

  static final String NAME_GENERAL = "general";

  static final String NAME_APP = "app";

  private String name;

  private Set<String> dependencies;

  Set<String> transitiveDependencies;

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
  public Component(String name, Set<String> dependencies) {

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
   * @return the {@link Set} of declared dependencies.
   */
  public Set<String> getDependencies() {

    if (this.dependencies == null) {
      this.dependencies = new HashSet<>();
    }
    return this.dependencies;
  }

  /**
   * @param dependencies new value of {@link #getDependencies()}.
   */
  public void setDependencies(Set<String> dependencies) {

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

    if (this.transitiveDependencies != null) {
      return this.transitiveDependencies.contains(dependentComponentName);
    } else {
      return getDependencies().contains(dependentComponentName);
    }
  }

  /**
   * @return the {@link Set} of transitive dependencies including {@link #getDependencies() declared dependencies} as
   *         well as {@link Architecture#hasTransitiveDependencies() transitive} dependencies (recursively). Is
   *         calculated outside of this bean and does not map to JSON. Will be {@code null} until
   *         {@link Configuration#initialize() initialization}.
   */
  public Set<String> transitiveDependencies() {

    return this.transitiveDependencies;
  }

}
