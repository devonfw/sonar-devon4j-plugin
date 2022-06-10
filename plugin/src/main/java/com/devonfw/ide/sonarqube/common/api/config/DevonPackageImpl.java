package com.devonfw.ide.sonarqube.common.api.config;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple implementation of {@link DevonPackage}.
 */
public class DevonPackageImpl implements DevonPackage {

  /** {@link Packages#getGroups() Group name} for the {@link #getComponent() component}. */
  public static final String GROUP_COMPONENT = "component";

  /** {@link Packages#getGroups() Group name} for the {@link #getLayer() layer}. */
  public static final String GROUP_LAYER = "layer";

  /** {@link Packages#getGroups() Group name} for the {@link #getScope() scope}. */
  public static final String GROUP_SCOPE = "scope";

  /** {@link Packages#getGroups() Group name} for the {@link #getDetail() detail}. */
  public static final String GROUP_DETAIL = "detail";

  /** {@link Packages#getGroups() Group name} of group to be ignored. */
  public static final String GROUP_IGNORE = "-";

  private static final Logger LOGGER = Logger.getLogger(DevonPackageImpl.class.getName());

  private final String packageName;

  private final boolean valid;

  private final String root;

  private final String component;

  private final String layer;

  private final String scope;

  private final String detail;

  private String application;

  private static final List<String> LAYERS = Arrays.asList(LAYER_BATCH, LAYER_CLIENT, LAYER_COMMON, LAYER_DATA_ACCESS,
      LAYER_LOGIC, LAYER_SERVICE);

  private static final List<String> SCOPES = Arrays.asList(SCOPE_API, SCOPE_BASE, SCOPE_IMPLEMENTATION);

  /**
   * The constructor.
   *
   * @param packageName the {@link #getPackage() package name}.
   * @param valid the {@link #isValid() valid flag}.
   * @param root the {@link #getRoot() root package}.
   * @param component the {@link #getComponent() component}.
   * @param layer the {@link #getLayer() layer}.
   * @param scope the {@link #getScope() scope}.
   * @param detail the {@link #getDetail() detail}.
   */
  public DevonPackageImpl(String packageName, boolean valid, String root, String component, String layer, String scope,
      String detail) {

    super();
    this.packageName = packageName;
    this.valid = valid;
    this.root = root;
    this.component = component;
    this.layer = layer;
    this.scope = scope;
    this.detail = detail;
  }

  @Override
  public String getPackage() {

    return this.packageName;
  }

  @Override
  public boolean isValid() {

    return this.valid;
  }

  @Override
  public String getRoot() {

    return this.root;
  }

  @Override
  public String getComponent() {

    return this.component;
  }

  @Override
  public String getLayer() {

    return this.layer;
  }

  @Override
  public boolean isValidLayer() {

    return LAYERS.contains((this.layer));
  }

  @Override
  public String getScope() {

    return this.scope;
  }

  @Override
  public boolean isValidScope() {

    return SCOPES.contains(this.scope);
  }

  @Override
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
  public String getDetail() {

    return this.detail;
  }

  @Override
  public String toString() {

    return this.packageName;
  }

  static DevonPackage ofOriginal(String packageName, Packages packages) {

    String root = "";
    boolean valid = false;
    String component = "";
    String layer = "";
    String scope = "";
    String detail = "";
    Pattern pattern = packages.patternRegex();
    Matcher matcher = pattern.matcher(packageName);
    int i = 1;
    if (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      if (start >= 1) {
        root = packageName.substring(0, start - 1);
        int segments = countChars(root, '.') + 1; // segments = #dots + 1
        if (segments >= packages.getMinimumRootSegments()) {
          if (end == packageName.length()) {
            valid = true;
            int groupCount = matcher.groupCount();
            for (String group : packages.getGroups()) {
              if (i > groupCount) {
                LOGGER.log(Level.WARNING,
                    "The package '" + packageName + "' contains more groups than declared in your architecture.json.");
                break;
              }
              String value = matcher.group(i);
              switch (group) {
                case GROUP_LAYER:
                  layer = value;
                  break;
                case GROUP_COMPONENT:
                  component = value;
                  break;
                case GROUP_SCOPE:
                  scope = value;
                  break;
                case GROUP_DETAIL:
                  detail = value;
                  break;
                case GROUP_IGNORE:
                  break;
                default:
                  LOGGER.log(Level.WARNING, "The group '" + group + "' is unknown.");
              }
              i++;
            }
          }
        }
      }
    }
    return new DevonPackageImpl(packageName, valid, root, component, layer, scope, detail);
  }

  private static int countChars(String string, char c) {

    int count = 0;
    int i = 0;
    while (i >= 0) {
      i = string.indexOf(c, i);
      count++;
      if (i >= 0) {
        i++;
      }
    }
    return count;
  }

}
