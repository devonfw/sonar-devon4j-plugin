package com.devonfw.ide.sonarqube.common.api.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * {@link Packages} of the {@link Architecture}.
 */
public class Packages {

  private static final String PATTERN_SEGMENT = "[a-zA-Z0-9_]+";

  private static final String PATTERN_LAYERS = DevonArchitecturePackage.LAYER_COMMON + "|"
      + DevonArchitecturePackage.LAYER_DATA_ACCESS + "|" + DevonArchitecturePackage.LAYER_SERVICE + "|"
      + DevonArchitecturePackage.LAYER_BATCH + "|" + DevonArchitecturePackage.LAYER_LOGIC + "|"
      + DevonArchitecturePackage.LAYER_CLIENT + "|gui";

  private static final String PATTERN_SCOPES = DevonArchitecturePackage.SCOPE_API + "|"
      + DevonArchitecturePackage.SCOPE_BASE + "|" + DevonArchitecturePackage.SCOPE_IMPLEMENTATION;

  private static final String DEFAULT_PATTERN = "(" + PATTERN_SEGMENT + ")\\.(" + PATTERN_LAYERS + ")\\.("
      + PATTERN_SCOPES + ")(\\." + PATTERN_SEGMENT + ")*";

  private static final List<String> DEFAULT_GROUPS = Arrays.asList(DevonArchitecturePackage.GROUP_COMPONENT,
      DevonArchitecturePackage.GROUP_LAYER, DevonArchitecturePackage.GROUP_SCOPE,
      DevonArchitecturePackage.GROUP_DETAIL);

  private String pattern;

  private transient Pattern regex;

  private Map<String, String> mappings;

  private List<String> groups;

  private int minimumRootSegments;

  /**
   * The constructor.
   */
  public Packages() {

  }

  /**
   * The constructor.
   *
   * @param pattern of this {@link Packages}.
   * @param mappings of this {@link Packages}.
   * @param groups of this {@link Packages}.
   */
  public Packages(String pattern, Map<String, String> mappings, List<String> groups) {

    this.pattern = pattern;
    this.mappings = mappings;
    this.groups = groups;
  }

  /**
   * @return the requested default {@link Packages}
   */
  public static Packages getDefault() {

    Map<String, String> defaultMappings = new HashMap<>();
    defaultMappings.put("gui", "client");

    Packages packages = new Packages(DEFAULT_PATTERN, defaultMappings, DEFAULT_GROUPS);
    packages.minimumRootSegments = 3;
    return packages;
  }

  /**
   * @return the regular expression pattern the {@link Class#getPackage() package} has to match. This pattern must not
   *         match the entire {@link Class#getPackage() package} as it excludes the
   *         {@link com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage#getRoot() root package}.
   */
  public String getPattern() {

    return this.pattern;
  }

  /**
   * @param pattern new value of {@link #getPattern()}.
   */
  public void setPattern(String pattern) {

    this.regex = null;
    this.pattern = pattern;
  }

  /**
   * @return the {@link #getPattern() pattern} compiled as regular expression {@link Pattern}. It will be lazily
   *         initialized. This is not a regular getter to prevent JSON serialization of this transient property.
   */
  public Pattern patternRegex() {

    if ((this.regex == null) && (this.pattern != null)) {
      this.regex = Pattern.compile(this.pattern);
    }
    return this.regex;
  }

  /**
   * @return a {@link Map} that may {@link Map#get(Object) re-map} specific package segments to the normalized default
   *         segment names used by devon4j. This allows e.g. to use {@code persistence} instead of {@code dataaccess},
   *         {@code core} instead of {@code logic}, or {@code gui} instead of {@code client}.
   */
  public Map<String, String> getMappings() {

    return this.mappings;
  }

  /**
   * @param mappings new value of {@link #getMappings()}.
   */
  public void setMappings(Map<String, String> mappings) {

    this.mappings = mappings;
  }

  /**
   * @return the {@link List} of the group names in order.
   */
  public List<String> getGroups() {

    return this.groups;
  }

  /**
   * @param groups new value of {@link #getGroups()}.
   */
  public void setGroups(List<String> groups) {

    this.groups = groups;
  }

  /**
   * @return the minimum number of package segments required for the
   *         {@link com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage#getRoot() root package}.
   */
  public int getMinimumRootSegments() {

    return this.minimumRootSegments;
  }

  /**
   * @param minimumRootSegments new value of {@link #getMinimumRootSegments()}.
   */
  public void setMinimumRootSegments(int minimumRootSegments) {

    this.minimumRootSegments = minimumRootSegments;
  }

}
