package com.devonfw.ide.sonarqube.common.api.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Package {
  private String[] segments;

  private int scopeIndex;

  private String pkg;

  private String root;

  private String detail;

  private static final Set<String> SCOPES = new HashSet(Arrays.asList("api", "base", "impl"));

  public Package(String packageName, String[] segments, String root, String detail, int scope) {
    Objects.requireNonNull(segments, "segments");
    this.pkg = packageName;

    for (int i = 0; i < segments.length; ++i) {
      if (!isValidSegment(segments[i])) {
        throw new IllegalArgumentException("segments[" + i + "] = " + segments[i]);
      }
    }

    this.root = root;
    this.detail = detail;
    this.segments = segments;
    this.scopeIndex = scope;
  }

  private static boolean isValidSegment(String segment) {

    if (segment == null) {
      return false;
    } else if (segment.isEmpty()) {
      return false;
    } else {
      return segment.indexOf(46) < 0;
    }
  }

  public String[] getSegments() {

    return segments;
  }

  public String getSegment(int index) {

    return index >= 0 && index < this.segments.length ? this.segments[index] : null;
  }

  public String getScope() {

    return getSegment(this.scopeIndex);
  }

  public String getLayer() {

    return getSegment(this.scopeIndex - 1);
  }

  public void setLayer(String givenLayer) {

    segments[this.scopeIndex - 1] = givenLayer;
  }

  public String getComponent() {

    return getSegment(this.scopeIndex - 2);
  }

  public String getApplication() {

    return this.getSegment(this.scopeIndex - 3);
  }

  public String getRoot() {

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < this.scopeIndex - 3; i++) {
      builder.append(segments[i] + ".");
    }
    return builder.toString();
  }

  public String getDetail() {

    return this.getSegment(this.scopeIndex + 1);
  }

  public String getClassName() {

    return this.getSegment(this.scopeIndex + 1);
  }

  public static Package of(String packageName) {

    String[] segments = packageName.split("\\.");
    int scopeIndex = -1;

    for (int i = 2; i < segments.length; ++i) {
      if (SCOPES.contains(segments[i])) {
        scopeIndex = i;
        break;
      }
    }

    return new Package(packageName, segments, (String) null, (String) null, scopeIndex);
  }

  @Override public String toString() {

    return this.pkg;
  }
}
