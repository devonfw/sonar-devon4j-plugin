package com.devonfw.ide.sonarqube.common.api.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DevonArchitecturePackage {

  private Packages packages;

  private Pattern pattern;

  private Matcher matcher;

  private String root = "";

  private String application;

  private String component = "";

  private String layer = "";

  private String scope = "";

  private String detail = "";

  private String packageName;

  private boolean valid;

  private static final Logger logger = Logger.getLogger("logger");

  private static final List<String> LAYERS = Arrays.asList("batch", "client", "common", "dataaccess", "logic",
      "service");

  private static final List<String> SCOPES = Arrays.asList("api", "base", "impl");

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
    this.matcher = this.pattern.matcher(packageName);
    this.packageName = packageName;
    setGroups(packageName);
  }

  public boolean isValid() {

    return this.valid;
  }

  public boolean isValidLayer() {

    return LAYERS.contains((this.layer));
  }

  public boolean isValidScope() {

    return SCOPES.contains(this.scope);
  }

  public boolean isLayerBatch() {

    return "batch".equals(this.layer);
  }

  public boolean isLayerClient() {

    return "client".equals(this.layer);
  }

  public boolean isLayerCommon() {

    return "common".equals(this.layer);
  }

  public boolean isLayerDataAccess() {

    return "dataaccess".equals(this.layer);
  }

  public boolean isLayerLogic() {

    return "logic".equals(this.layer);
  }

  public boolean isLayerService() {

    return "service".equals(this.layer);
  }

  public boolean isScopeApi() {

    return "api".equals(this.scope);
  }

  public boolean isScopeBase() {

    return "base".equals(this.scope);
  }

  public boolean isScopeImpl() {

    return "impl".equals(this.scope);
  }

  public String getComponent() {

    return this.component;
  }

  public String getLayer() {

    return this.layer;
  }

  public String getRoot() {

    return this.root;
  }

  public String getScope() {

    return this.scope;
  }

  public String getPackage() {

    return this.packageName;
  }

  public String getApplication() {

    if (this.application == null) {
      int lastIndexOfRoot = this.root.lastIndexOf(".");
      if (lastIndexOfRoot > 0) {
        this.application = this.root.substring(lastIndexOfRoot + 1);
      } else {
        this.application = this.root;
      }
    }
    return this.application;
  }

  @Override
  public String toString() {

    return this.packageName;
  }

  private void setGroups(String packageName) {

    int i = 1;
    if (this.matcher.find()) {
      int start = this.matcher.start();
      int end = this.matcher.end();
      if (start >= 1) {
        this.root = packageName.substring(0, start - 1);
      } else {
        return;
      }
      if (end == packageName.length()) {
        this.valid = true;
        int groupCount = this.matcher.groupCount();
        for (String group : this.packages.getGroups()) {
          if (i > groupCount) {
            logger.log(Level.WARNING,
                "The package '" + packageName + "' contains more groups than declared in your architecture.json.");
            break;
          }
          String value = replaceLayerOrScope(this.matcher.group(i));
          switch (group) {
            case "layer":
              this.layer = value;
              break;
            case "component":
              this.component = value;
              break;
            case "scope":
              this.scope = value;
              break;
            case "detail":
              this.detail = value;
              break;
            case "-":
              break;
            case "application":
              this.application = value;
              break;
            default:
              logger.log(Level.WARNING, "The group '" + group + "' is unknown.");
          }
          i++;
        }
      } else {
        logger.log(Level.WARNING,
            "The package '" + packageName + "' does not follow the pattern you entered in your architecture.json.");
      }
    }
  }

  public static String joinSegments(String firstSegment, String secondSegment) {

    if (firstSegment == null || firstSegment.isEmpty()) {
      return secondSegment;
    }

    if (secondSegment == null || secondSegment.isEmpty()) {
      return firstSegment;
    }

    return firstSegment + "." + secondSegment;
  }

  private String replaceLayerOrScope(String layerOrScope) {

    return Optional.ofNullable(this.packages.getMappings().get(layerOrScope)).orElse(layerOrScope);
  }

}
