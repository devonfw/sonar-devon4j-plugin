package com.devonfw.ide.sonarqube.common.impl.config;

import java.io.File;

import com.devonfw.ide.sonarqube.common.api.config.Configuration;

/**
 * Factory to access the {@link Configuration}.
 */
public class ConfigurationFactory {

  private static final String ARCHITECTURE_JSON = "architecture.json";

  private static final ConfigurationMapper MAPPER = new ConfigurationMapper();

  /**
   * @param fileToScan the {@link File} to analyze.
   * @return the {@link Configuration} responsible for the project owning the given {@link File}.
   */
  public static Configuration get(File fileToScan) {

    File configFile = findConfigFile(fileToScan.getParentFile());
    if (configFile == null) {
      System.out.println("********** Configuration not found starting from " + fileToScan.getAbsolutePath());
      return null;
    }
    System.out.println("********** Configuration found at " + configFile.getAbsolutePath());
    return MAPPER.fromJson(configFile);
  }

  private static File findConfigFile(File folder) {

    if (folder == null) {
      return null;
    }
    File configFile = new File(folder, ARCHITECTURE_JSON);
    if (configFile.exists()) {
      return configFile;
    }
    return findConfigFile(folder.getParentFile());
  }

}
