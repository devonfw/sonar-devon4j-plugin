package com.devonfw.ide.sonarqube.common.api.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 */
public class ArchitectureJsonReader {

  private Logger logger = Logger.getGlobal();

  private File architectureDirectory;

  private static final String ARCHITECTURE_JSON = "architecture.json";

  // Use this constructor only for testing purposes
  public ArchitectureJsonReader(File architectureDirectory) {

    this.architectureDirectory = architectureDirectory;
  }

  /**
   * The constructor.
   */
  public ArchitectureJsonReader() {

    this(new File(ARCHITECTURE_JSON));
  }

  /**
   * @return
   */
  public boolean isDevon4jProject() {

    JSONObject jsonObject = getArchitectureJson();
    if (jsonObject == null) {
      return true;
    }
    JSONObject architecture = (JSONObject) jsonObject.get("architecture");
    if (architecture == null) {
      return true;
    }
    Boolean devonProject = (Boolean) architecture.get("devonProject");
    if (devonProject == null) {
      return true;
    }
    return devonProject;
  }

  private JSONObject getArchitectureJson() {

    JSONParser parser = new JSONParser();
    JSONObject jsonObject = null;
    try (FileReader fileReader = new FileReader(architectureDirectory)) {
      jsonObject = (JSONObject) parser.parse(fileReader);
    } catch (IOException e) {
      this.logger.log(Level.INFO, "File architecture.json cannot be found");
    } catch (ParseException e) {
      this.logger.log(Level.INFO, "File architecture.json cannot be parsed");
    }
    return jsonObject;
  }

  private JSONObject getArchitectureProperty() {

    JSONObject jsonObject = getArchitectureJson();
    if (jsonObject == null) {
      return null;
    }

    return (JSONObject) jsonObject.get("architecture");
  }

  private JSONObject getPackageNamingConvention() {

    JSONObject architecture = getArchitectureProperty();
    if (architecture == null) {
      return null;
    }
    JSONObject packages = (JSONObject) architecture.get("packages");

    return packages;
  }

  /**
   * @return
   */
  public String getPackageNamingPattern() {

    JSONObject packageNamingConvention = getPackageNamingConvention();
    if (packageNamingConvention == null) {
      return null;
    }
    Object pattern = packageNamingConvention.get("pattern");
    return pattern != null ? pattern.toString() : null;
  }

  /**
   * @return
   */
  public Map<String, String> getPackageNameMappings() {

    Map<String, String> nameMappings = new HashMap<>();
    JSONObject packageNamingConvention = getPackageNamingConvention();
    if (packageNamingConvention == null) {
      return null;
    }
    JSONObject mappings = (JSONObject) packageNamingConvention.get("mappings");
    if (mappings == null) {
      return null;
    }

    for (Object key : mappings.keySet()) {
      nameMappings.put(key.toString(), mappings.get(key).toString());
    }
    return nameMappings;
  }

  /**
   * @param layerName
   * @return
   */
  public String getNameMappingForGivenLayer(String layerName) {

    Map<String, String> packageNameMappings = getPackageNameMappings();
    if (packageNameMappings == null) {
      return null;
    }
    return packageNameMappings.containsKey(layerName) ? packageNameMappings.get(layerName) : null;
  }

}
