package com.devonfw.ide.sonarqube.common.impl.config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.devonfw.ide.sonarqube.common.api.config.Configuration;

/**
 * Factory to access the {@link Configuration} and do caching for efficient analysis.
 */
public class ConfigurationFactory {

  private static final ConfigurationFactory INSTANCE = new ConfigurationFactory();

  private final ConfigurationMapper mapper;

  // this plugin is executed on the client during analysis, we do not expect a memory leak here
  private final Map<String, Configuration> path2configMap;

  private String lastConfigFolderPath;

  /**
   * The constructor.
   */
  public ConfigurationFactory() {

    super();
    this.mapper = new ConfigurationMapper();
    this.path2configMap = new HashMap<>();
  }

  /**
   * @param path to the file to analyze.
   * @return the {@link Configuration} responsible for the project owning the given {@link File}.
   */
  public static Configuration get(String path) {

    return INSTANCE.getConfiguration(path);
  }

  /**
   * @param path to the file to analyze.
   * @return the {@link Configuration} responsible for the project owning the given {@link File}.
   */
  public Configuration getConfiguration(String path) {

    if (this.lastConfigFolderPath != null) {
      if (path.startsWith(this.lastConfigFolderPath)) {
        return this.path2configMap.get(this.lastConfigFolderPath);
      }
    }
    int lastSlash = path.lastIndexOf("/");
    String pathOfParent = path.substring(0, lastSlash);
    File configFile = findConfigFile(new File(pathOfParent));
    if (configFile == null) {
      System.out.println("********** Configuration not found starting from " + path);
      return null;
    }
    System.out.println("********** Configuration found at " + configFile.getAbsolutePath());
    File configFolder = configFile.getParentFile();
    String configFolderPath = configFolder.getAbsolutePath();
    if (!configFolderPath.endsWith(File.separator)) {
      configFolderPath = configFolderPath + File.separator;
    }
    Configuration configuration = this.mapper.fromJson(configFile);
    this.path2configMap.put(configFolderPath, configuration);
    this.lastConfigFolderPath = configFolderPath;
    return configuration;
  }

  private static File findConfigFile(File folder) {

    if (folder == null) {
      return null;
    }
    File configFile = new File(folder, Configuration.ARCHITECTURE_JSON);
    if (configFile.exists()) {
      return configFile;
    }
    return findConfigFile(folder.getParentFile());
  }

}
