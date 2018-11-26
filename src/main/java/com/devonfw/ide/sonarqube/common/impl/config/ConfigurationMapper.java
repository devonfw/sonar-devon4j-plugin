package com.devonfw.ide.sonarqube.common.impl.config;

import java.io.File;
import java.io.IOException;

import com.devonfw.ide.sonarqube.common.api.config.Configuration;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class to map {@link Configuration} from/to JSON.
 */
public class ConfigurationMapper {

  private final ObjectMapper objectMapper;

  /**
   * The constructor.
   */
  public ConfigurationMapper() {

    super();
    this.objectMapper = new ObjectMapper();
    this.objectMapper.setSerializationInclusion(Include.NON_NULL);
    this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  /**
   * @param json the JSON to parse as {@link String}.
   * @return the given JSON parsed as {@link Configuration}.
   */
  public Configuration fromJson(String json) {

    try {
      return this.objectMapper.readValue(json, Configuration.class);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * @param json the {@link File} pointing to the JSON configuration.
   * @return the specified JSON parsed as {@link Configuration}.
   */
  public Configuration fromJson(File json) {

    try {
      return this.objectMapper.readValue(json, Configuration.class);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * @param config the {@link Configuration} to serialize.
   * @return the given {@link Configuration} as a JSON {@link String}.
   */
  public String toJson(Configuration config) {

    try {
      return this.objectMapper.writeValueAsString(config);
    } catch (JsonProcessingException e) {
      throw new IllegalStateException(e);
    }
  }

}
