package com.devonfw.ide.sonarqube.common.api.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    this.pattern = Pattern.compile(this.packages.getPattern());
    setPatternGroups();
    this.matcher = this.pattern.matcher(packageName);

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

    return replaceLayerOrScope(this.matcher.group(2)).matches("batch");
  }

  public boolean isLayerClient() {

    return replaceLayerOrScope(this.matcher.group(2)).matches("client");
  }

  public boolean isLayerCommon() {

    return replaceLayerOrScope(this.matcher.group(2)).matches("common");
  }

  public boolean isLayerDataAccess() {

    return replaceLayerOrScope(this.matcher.group(2)).matches("dataaccess");
  }

  public boolean isLayerLogic() {

    return replaceLayerOrScope(this.matcher.group(2)).matches("logic");
  }

  public boolean isLayerService() {

    return replaceLayerOrScope(this.matcher.group(2)).matches("service");
  }

  public boolean isScopeApi() {

    return replaceLayerOrScope(this.matcher.group(4)).matches("api");
  }

  public boolean isScopeBase() {

    return replaceLayerOrScope(this.matcher.group(4)).matches("base");
  }

  public boolean isScopeImpl() {

    return replaceLayerOrScope(this.matcher.group(4)).matches("impl");
  }

  public String getApplication() {

    return this.matcher.group(0).substring(this.matcher.start(5) + 1, this.matcher.end(5));
  }

  public String getComponent() {

    return this.matcher.group(3);
  }

  public String getLayer() {

    return this.matcher.group(2);
  }

  public String getRoot() {

    return this.matcher.group(0).substring(0, this.matcher.end(1) - 1);
  }

  public String getScope() {

    return this.matcher.group(4);
  }

  private void setPatternGroups() {

    List<String> patternGroups = getPatternGroups(this.packages.getPattern());
    this.layerPattern = Pattern.compile(patternGroups.get(1));
    this.scopePattern = Pattern.compile(patternGroups.get(3));
  }

  private List<String> getPatternGroups(String stringPattern) {

    List<String> patternGroups = new ArrayList<>();
    Matcher m = Pattern.compile("\\((.*?)\\)").matcher(stringPattern);
    while (m.find()) {
      patternGroups.add(m.group(1));
    }
    return patternGroups;
  }

  private String replaceLayerOrScope(String layerOrScope) {

    return Optional.ofNullable(this.packages.getMappings().get(layerOrScope)).orElse(layerOrScope);
  }

}