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

  private String root;

  private String layer;

  private String component;

  private String scope;

  private String detail;

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
    setGroups(packageName);
  }

  public boolean isValid() {

    return this.matcher.matches();
  }

  public boolean isValidLayer() {

    return LAYERS.contains(replaceLayerOrScope(this.layer));
  }

  public boolean isValidScope() {

    return SCOPES.contains(replaceLayerOrScope(this.scope));
  }

  public boolean isLayerBatch() {

    return replaceLayerOrScope(this.layer).matches("batch");
  }

  public boolean isLayerClient() {

    return replaceLayerOrScope(this.layer).matches("client");
  }

  public boolean isLayerCommon() {

    return replaceLayerOrScope(this.layer).matches("common");
  }

  public boolean isLayerDataAccess() {

    return replaceLayerOrScope(this.layer).matches("dataaccess");
  }

  public boolean isLayerLogic() {

    return replaceLayerOrScope(this.layer).matches("logic");
  }

  public boolean isLayerService() {

    return replaceLayerOrScope(this.layer).matches("service");
  }

  public boolean isScopeApi() {

    return replaceLayerOrScope(this.scope).matches("api");
  }

  public boolean isScopeBase() {

    return replaceLayerOrScope(this.scope).matches("base");
  }

  public boolean isScopeImpl() {

    return replaceLayerOrScope(this.scope).matches("impl");
  }

  public String getApplication() {

    return this.detail;
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

  private void setGroups(String packageName) {

    int i = 1;
    if (isValid()) {

      int groupCount = this.matcher.groupCount();
      for (String group : this.packages.getGroups()) {
        if (i > groupCount) {
          logger.log(Level.WARNING,
              "The package '" + packageName + "' contains more groups than declared in your architecture.json.");
          break;
        }
        String value = this.matcher.group(i);
        switch (group) {
          case "root":
            this.root = value;
            break;
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

  private String replaceLayerOrScope(String layerOrScope) {

    return Optional.ofNullable(this.packages.getMappings().get(layerOrScope)).orElse(layerOrScope);
  }

}