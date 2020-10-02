package com.devonfw.ide.sonarqube.common.api.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link Packages} of the {@link Architecture}.
 */
public class Packages {

  private String pattern;

  private Map<String, String> mappings;

  private List<String> groups;

  private static final String DEFAULT_PATTERN =
      "([a-zA-Z0-9_]+\\.)+(dataaccess|service|batch|gui|client)\\.([a-zA-Z0-9_]+)\\.(api|base|impl)(\\.[a-zA-Z0-9_]+)*";

  private static final List<String> defaultGroups = Arrays.asList("root", "application", "component", "layer", "scope",
      "detail");

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

    return new Packages(DEFAULT_PATTERN, new HashMap<>(), defaultGroups);
  }

  /**
   * @return pattern
   */
  public String getPattern() {

    return this.pattern;
  }

  /**
   * @param pattern new value of {@link #getPattern()}.
   */
  public void setPattern(String pattern) {

    this.pattern = pattern;
  }

  /**
   * @return mappings
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
   * @return groups
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

}
