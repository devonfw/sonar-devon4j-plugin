package com.devonfw.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DevonArchitecturePackage {

  private Packages packages;

  private Pattern pattern;

  private Pattern layerPattern;

  private Pattern scopePattern;

  private Matcher matcher;

  private static final Logger logger = Logger.getLogger("logger");

  /**
   *
   * The constructor.
   *
   * @param packageName Name of the package to check for validity
   * @param packages Packages object containing the info provided by the user inside architecture.json
   */
  public DevonArchitecturePackage(String packageName, Packages packages) {

    this.packages = packages;
    this.packages.setPattern(replaceMappings(packages.getPattern()));
    this.pattern = Pattern.compile(this.packages.getPattern());
    setPatternGroups();
    this.matcher = this.pattern.matcher(replaceMappings(packageName));

    if (!isValid()) {
      logger.log(Level.WARNING,
          "The package '" + packageName + "' does not follow the pattern you entered in your architecture.json.");
      return;
    }
  }

  public boolean isValid() {

    return this.matcher.matches();
  }

  public boolean isValidLayer() {

    return this.layerPattern.matcher(this.matcher.group(2)).matches();
  }

  public boolean isValidScope() {

    return this.scopePattern.matcher(this.matcher.group(4)).matches();
  }

  public boolean isLayerBatch() {

    return this.matcher.group(2).matches("batch");
  }

  public boolean isLayerClient() {

    return this.matcher.group(2).matches("client");
  }

  public boolean isLayerCommon() {

    return this.matcher.group(2).matches("common");
  }

  public boolean isLayerDataAccess() {

    return this.matcher.group(2).matches("dataaccess");
  }

  public boolean isLayerLogic() {

    return this.matcher.group(2).matches("logic");
  }

  public boolean isLayerService() {

    return this.matcher.group(2).matches("service");
  }

  public boolean isScopeApi() {

    return this.matcher.group(4).matches("api");
  }

  public boolean isScopeBase() {

    return this.matcher.group(4).matches("base");
  }

  public boolean isScopeImpl() {

    return this.matcher.group(4).matches("impl");
  }

  public String getApplication() {

    return this.matcher.group(5);
  }

  public String getComponent() {

    return this.matcher.group(3);
  }

  public String getLayer() {

    return this.matcher.group(2);
  }

  public String getRoot() {

    return this.matcher.group(1);
  }

  public String getScope() {

    return this.matcher.group(4);
  }

  private List<String> getPatternGroups(String stringPattern) {

    List<String> patternGroups = new ArrayList<>();
    Matcher m = Pattern.compile("\\((.*?)\\)").matcher(stringPattern);
    while (m.find()) {
      patternGroups.add(m.group(1));
    }
    return patternGroups;
  }

  private void setPatternGroups() {

    List<String> patternGroups = getPatternGroups(this.packages.getPattern());
    this.layerPattern = Pattern.compile(patternGroups.get(1));
    this.scopePattern = Pattern.compile(patternGroups.get(3));
  }

  private String replaceMappings(String packageName) {

    Map<String, String> mappings = this.packages.getMappings();
    for (String key : mappings.keySet()) {
      packageName = packageName.replace(key, mappings.get(key));
    }
    return packageName;
  }

}