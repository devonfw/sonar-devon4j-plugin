package com.devonfw.ide.sonarqube.common.api.config;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DevonArchitecturePackage {

  // private Devon4jPackage devon4jPackage;

  private String packageName;

  private Packages packages;

  private Pattern pattern;

  private Matcher matcher;

  private Map<String, String> groupValues;

  private Logger logger = Logger.getLogger("logger");

  public DevonArchitecturePackage(String packageName, Packages packages) {

    this.packages = packages;
    this.packageName = packageName;
    this.groupValues = new HashMap<>();
    this.pattern = Pattern.compile(this.packages.getPattern());
    this.logger.log(Level.INFO, this.pattern.toString());
    this.matcher = this.pattern.matcher(this.packageName);
    this.logger.log(Level.INFO, "Group of this packageName: " + this.matcher.group(2));
    // this.devon4jPackage = Devon4jPackage.of(packageName);
  }

  private void setGroupValues() {

  }

  public boolean isValid() {

    return false;
  }

  public boolean isValidLayer() {

    return false;
  }

  public boolean isValidScope() {

    return false;
  }

  public boolean isLayerBatch() {

    return false;
  }

  public boolean isLayerClient() {

    return false;
  }

  public boolean isLayerCommon() {

    return false;
  }

  public boolean isLayerDataAccess() {

    return false;
  }

  public boolean isLayerLogic() {

    return false;
  }

  public boolean isLayerService() {

    return false;
  }

  public boolean isScopeApi() {

    return false;
  }

  public boolean isScopeBase() {

    return false;
  }

  public boolean isScopeImpl() {

    return false;
  }

  public String getApplication() {

    return null;
  }

  public String getComponent() {

    return null;
  }

  public String getLayer() {

    return null;
  }

  public String getRoot() {

    return null;
  }

  public String getScope() {

    return null;
  }

}