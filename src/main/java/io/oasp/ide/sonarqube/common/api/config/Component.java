package io.oasp.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssabah
 *
 */
public class Component {

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
   * @param name new value of {@link #getname}.
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
   * @param dependencies new value of {@link #getdependencies}.
   */
  public void setDependencies(List<String> dependencies) {

    this.dependencies = dependencies;
  }

  /**
   * @param name
   * @return
   */
  public boolean hasDependency(String name) {

    for (String dependency : getDependencies()) {
      if (dependency.equals(name)) {
        return true;
      }
    }
    return false;
  }

}
