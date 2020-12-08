package com.devonfw.ide.sonarqube.common.api.config;

/**
 * Wrapper for a {@link Class#getPackage() package} as structural representation according to the {@link Packages}
 * definition of the architecture {@link com.devonfw.ide.sonarqube.common.api.config.Configuration}.
 */
public class DevonArchitecturePackage extends DevonPackageImpl {

  private final DevonPackage unresolved;

  /**
   * The constructor.
   *
   * @param ori the {@link #getUnresolved() original package}.
   * @param packages the {@link Packages}.
   */
  public DevonArchitecturePackage(DevonPackage ori, Packages packages) {

    super(ori.getPackage(), ori.isValid(), ori.getRoot(), resolve(ori.getComponent(), packages),
        resolve(ori.getLayer(), packages), resolve(ori.getScope(), packages), ori.getDetail());
    this.unresolved = ori;
  }

  /**
   * @return original {@link DevonPackage} with unresolved segments.
   */
  public DevonPackage getUnresolved() {

    return this.unresolved;
  }

  /**
   * @param packageName the {@link #getPackage() package name}.
   * @param packages the {@link Packages}.
   * @return the parsed {@link DevonArchitecturePackage}.
   */
  public static DevonArchitecturePackage of(String packageName, Packages packages) {

    DevonPackage originalPackage = ofOriginal(packageName, packages);
    return new DevonArchitecturePackage(originalPackage, packages);
  }

  private static String resolve(String segment, Packages packages) {

    String replacement = packages.getMappings().get(segment);
    if (replacement != null) {
      return replacement;
    }
    return segment;
  }

}
