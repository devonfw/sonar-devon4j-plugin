package com.devonfw.ide.sonarqube.common.api.config;

/**
 * The {@link Configuration} for this plugin.
 */
public class Configuration {

  private Architecture architecture;

  /**
   * @return the {@link Architecture}.
   */
  public Architecture getArchitecture() {

    if (this.architecture == null) {
      this.architecture = new Architecture();
    }
    return this.architecture;
  }

  /**
   * @param architecture new value of {@link #getArchitecture()}.
   */
  public void setArchitecture(Architecture architecture) {

    this.architecture = architecture;
  }

}
