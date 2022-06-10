package com.devonfw.ide.sonarqube.common.api.config;

/**
 * The {@link Configuration} for this plugin. It defines the architecture of the current project.
 */
public class Configuration {

  /** Default filename of the file for this {@link Configuration}. */
  public static final String ARCHITECTURE_JSON = "architecture.json";

  private Architecture architecture;

  private Status status;

  /**
   * The constructor.
   */
  public Configuration() {

    super();
    this.status = new Status();
  }

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

  /**
   * @return the status of this {@link Configuration}.
   */
  public Status status() {

    return this.status;
  }

  /**
   * Properly initializes this configuration.
   *
   * @param source the source where the configuration was loaded from.
   */
  public void initialize(String source) {

    this.status.source = source;
    if (this.architecture == null) {
      this.status.addError("The configuration file architecture.json is missing the property \"architecture\".");
      this.architecture = new Architecture();
    }
    this.architecture.initialize(this);
  }

}
