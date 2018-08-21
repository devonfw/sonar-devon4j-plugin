package io.oasp.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssabah
 *
 */

public class BusinessArchitecture {

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
   * @param components new value of {@link #getcomponents}.
   */
  public void setComponents(List<Component> components) {

    this.components = components;
  }

}
