package com.devonfw.ide.sonarqube.common.api;

import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.api.config.DevonPackage;

/**
 * Simple representation of a Java type.
 */
public class JavaType {

  private final DevonArchitecturePackage pkg;

  private final String simpleName;

  /**
   * The constructor.
   *
   * @param pkg the {@link DevonArchitecturePackage} representing the {@link Class#getPackage() package} of the type.
   * @param simpleName the {@link Class#getSimpleName() simple name} of the type.
   */
  public JavaType(DevonArchitecturePackage pkg, String simpleName) {

    super();
    this.pkg = pkg;
    this.simpleName = simpleName;
  }

  /**
   * @return the {@link Class#getSimpleName() simple name} of the type.
   */
  public String getSimpleName() {

    return this.simpleName;
  }

  /**
   * @return the {@link Class#getPackage() package} of the type as plain {@link String}.
   */
  public String getPackage() {

    return this.pkg.getPackage();
  }

  /**
   * @return the {@link Class#getPackage() package} of the type as {@link DevonArchitecturePackage}.
   */
  public DevonArchitecturePackage getDevonPackage() {

    return this.pkg;
  }

  /**
   * @return the {@link Class#getName() qualified name} of this {@link JavaType} composed of {@link #getPackage()
   *         package} and {@link #getSimpleName() simple name}.
   */
  public String getQualifiedName() {

    return DevonPackage.composePackage(this.pkg.getPackage(), this.simpleName);
  }

  @Override
  public String toString() {

    return getQualifiedName();
  }

}
