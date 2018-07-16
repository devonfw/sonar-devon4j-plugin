package io.oasp.ide.sonarqube.common.impl.config;

import java.io.IOException;

import net.sf.mmm.util.io.api.IoMode;
import net.sf.mmm.util.io.api.RuntimeIoException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.oasp.ide.sonarqube.common.api.config.Config;

/**
 * @author ssabah
 *
 */
public class ConfigMapper {

  private final ObjectMapper jsonMapper;

  /**
   * The constructor.
   */
  public ConfigMapper() {

    super();
    this.jsonMapper = new ObjectMapper();
  }

  public Config fromJson(String json) {

    try {
      return this.jsonMapper.readValue(json, Config.class);
    } catch (IOException e) {
      throw new RuntimeIoException(e, IoMode.READ);
    }
  }

  public String toJson(Config config) {

    try {
      return this.jsonMapper.writeValueAsString(config);
    } catch (JsonProcessingException e) {
      throw new RuntimeIoException(e, IoMode.WRITE);
    }
  }

}
