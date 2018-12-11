package com.devonfw.ide.sonarqube.common.api.config;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link Component} of the {@link Architecture}.
 *
 * @see com.devonfw.module.basic.common.api.reflect.Devon4jPackage#getComponent()
 */
public class Component {

  /** {@link #getName() Name} of general component (for cross-cutting code). */
  public static final String NAME_GENERAL = "general";

  /** {@link #getName() Name} of app component (for application orchestration). */
  public static final String NAME_APP = "app";

  private String name;

  private Set<String> dependencies;

  private Set<String> nonTransitiveDependencies;

  Set<String> allDependencies;

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
   * @return the {@link Set} of declared and transitive dependencies.
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
   * @return the {@link Set} of declared, non-transitive dependencies.
   */
  public Set<String> getNonTransitiveDependencies() {

    return this.nonTransitiveDependencies;
  }

  /**
   * @param nonTransitiveDependencies new value of {@link #getNonTransitiveDependencies()}.
   */
  public void setNonTransitiveDependencies(Set<String> nonTransitiveDependencies) {

    if (this.nonTransitiveDependencies != null) {
      throw new IllegalStateException();
    }
    this.nonTransitiveDependencies = nonTransitiveDependencies;
  }

  /**
   * @param dependentComponentName the {@link #getName() name} of the dependent {@link Component}.
   * @return {@code true} if this {@link Component} has a {@link #getDependencies() defined dependency} on the
   *         {@link Component} with the given {@link #getName() name}, {@code false} otherwise.
   */
  public boolean hasDependency(String dependentComponentName) {

    if (this.allDependencies != null) {
      return this.allDependencies.contains(dependentComponentName);
    } else {
      if ((this.nonTransitiveDependencies != null) && this.nonTransitiveDependencies.contains(dependentComponentName)) {
        return true;
      }
      return getDependencies().contains(dependentComponentName);
    }
  }

  /**
   * @return the {@link Set} of transitive dependencies including {@link #getNonTransitiveDependencies() non-transitive
   *         dependencies} as well as {@link #getDependencies() declared and transitive dependencies} (recursively). Is
   *         calculated outside of this bean and does not map to JSON. Will be {@code null} until
   *         {@link Configuration#initialize(String) initialization}.
   */
  public Set<String> allDependencies() {

    return this.allDependencies;
  }

}
