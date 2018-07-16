package io.oasp.ide.sonarqube.common.impl.config;

/**
 * @author ssabah
 *
 */
public class ConfigAccess {

  private final ConfigMapper configMapper;

  /**
   * The constructor.
   */
  public ConfigAccess() {

    super();
    this.configMapper = new ConfigMapper();
  }

}
