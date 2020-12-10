package com.devonfw.ide.sonarqube.common.api.config;

/**
 * Wrapper for a {@link Class#getPackage() package} as structural representation according to the {@link Packages}
 * definition of the architecture {@link com.devonfw.ide.sonarqube.common.api.config.Configuration}.
 */
public interface DevonPackage {

  /** Package segment name for the api {@link #getScope() scope}. */
  String SCOPE_API = "api";

  /** Package segment name for the base {@link #getScope() scope}. */
  String SCOPE_BASE = "base";

  /** Package segment name for the implementation {@link #getScope() scope}. */
  String SCOPE_IMPLEMENTATION = "impl";

  /** Package segment name for the common {@link #getLayer() layer}. */
  String LAYER_COMMON = "common";

  /** Package segment name for the data-access {@link #getLayer() layer}. */
  String LAYER_DATA_ACCESS = "dataaccess";

  /** Package segment name for the logic {@link #getLayer() layer}. */
  String LAYER_LOGIC = "logic";

  /** Package segment name for the service {@link #getLayer() layer}. */
  String LAYER_SERVICE = "service";

  /** Package segment name for the batch {@link #getLayer() layer}. */
  String LAYER_BATCH = "batch";

  /** Package segment name for the batch {@link #getLayer() layer}. */
  String LAYER_CLIENT = "client";

  /**
   * @return the {@link Class#getPackage() package} as plain {@link String}.
   */
  String getPackage();

  /**
   * @return {@code true} if this {@link #getPackage() package} is valid according to the
   *         {@link com.devonfw.ide.sonarqube.common.api.config.Packages} definition of the architecture
   *         {@link com.devonfw.ide.sonarqube.common.api.config.Configuration}, {@code false} otherwise.
   */
  boolean isValid();

  /**
   * @return the name of the root-package before the pattern matched. Will be the empty {@link String} if not
   *         {@link #isValid() valid}.
   */
  String getRoot();

  /**
   * @param otherPkg the other {@link DevonPackage} to compare.
   * @return {@code true} if both this and the given {@link DevonPackage}s have the same {@link #getRoot() root},
   *         {@code false} otherwise.
   */
  default boolean hasSameRoot(DevonPackage otherPkg) {

    return getRoot().equals(otherPkg.getRoot());
  }

  /**
   * @return the name of the component. Will be the empty {@link String} if not {@link #isValid() valid}.
   */
  String getComponent();

  /**
   * @return the {@link #composePackage(String, String) package-fragment composed} of {@link #getComponent() component}
   *         and {@link #getLayer() layer}.
   */
  default String getComponentAndLayer() {

    return composePackage(getComponent(), getLayer());
  }

  /**
   * @return the {@link #composePackage(String, String) package-fragment composed} of {@link #getComponent() component},
   *         {@link #getLayer() layer}, and {@link #getScope() scope}.
   */
  default String getComponentAndLayerAndScope() {

    return composePackage(getComponentAndLayer(), getScope());
  }

  /**
   * @param otherPkg the other {@link DevonPackage} to compare.
   * @return {@code true} if both this and the given {@link DevonPackage}s have the same {@link #getComponent()
   *         component}, {@code false} otherwise.
   */
  default boolean hasSameComponent(DevonPackage otherPkg) {

    return getComponent().equals(otherPkg.getComponent());
  }

  /**
   * @return {@code true} if the {@link #getComponent() component} is {@link Component#NAME_GENERAL general},
   *         {@code false} otherwise.
   */
  default boolean isComponentGeneral() {

    return Component.NAME_GENERAL.equals(getComponent());
  }

  /**
   * @param otherPkg the other {@link DevonPackage} to compare.
   * @return {@code true} if both this and the given {@link DevonPackage}s have the same {@link #getComponent()
   *         component}, {@link #getLayer() layer}, and {@link #getRoot() root}, {@code false} otherwise.
   */
  default boolean hasSameComponentPart(DevonPackage otherPkg) {

    return hasSameComponent(otherPkg) && hasSameLayer(otherPkg) && hasSameRoot(otherPkg);
  }

  /**
   * @return the name of the layer. Will be the empty {@link String} if not {@link #isValid() valid}.
   */
  String getLayer();

  /**
   * @param otherPkg the other {@link DevonPackage} to compare.
   * @return {@code true} if both this and the given {@link DevonPackage}s have the same {@link #getLayer() layer},
   *         {@code false} otherwise.
   */
  default boolean hasSameLayer(DevonPackage otherPkg) {

    return getLayer().equals(otherPkg.getLayer());
  }

  /**
   * @return {@code true} if the {@link #getLayer() layer} is a valid devon4j layer, {@code false} otherwise.
   */
  boolean isValidLayer();

  /**
   * @return {@code true} if the {@link #getLayer() layer} is {@link #LAYER_BATCH batch}, {@code false} otherwise.
   */
  default boolean isLayerBatch() {

    return LAYER_BATCH.equals(getLayer());
  }

  /**
   * @return {@code true} if the {@link #getLayer() layer} is {@link #LAYER_CLIENT client}, {@code false} otherwise.
   */
  default boolean isLayerClient() {

    return LAYER_CLIENT.equals(getLayer());
  }

  /**
   * @return {@code true} if the {@link #getLayer() layer} is {@link #LAYER_COMMON common}, {@code false} otherwise.
   */
  default boolean isLayerCommon() {

    return LAYER_COMMON.equals(getLayer());
  }

  /**
   * @return {@code true} if the {@link #getLayer() layer} is {@link #LAYER_DATA_ACCESS dataaccess}, {@code false}
   *         otherwise.
   */
  default boolean isLayerDataAccess() {

    return LAYER_DATA_ACCESS.equals(getLayer());
  }

  /**
   * @return {@code true} if the {@link #getLayer() layer} is {@link #LAYER_LOGIC logic}, {@code false} otherwise.
   */
  default boolean isLayerLogic() {

    return LAYER_LOGIC.equals(getLayer());
  }

  /**
   * @return {@code true} if the {@link #getLayer() layer} is {@link #LAYER_SERVICE service}, {@code false} otherwise.
   */
  default boolean isLayerService() {

    return LAYER_SERVICE.equals(getLayer());
  }

  /**
   * @return the name of the scope. Will be the empty {@link String} if not {@link #isValid() valid}.
   */
  default String getScope() {

    return getScope();
  }

  /**
   * @return {@code true} if the {@link #getScope() scope} is a valid devon4j scope, {@code false} otherwise.
   */
  boolean isValidScope();

  /**
   * @return {@code true} if the {@link #getScope() scope} is {@link #SCOPE_API api}, {@code false} otherwise.
   */
  default boolean isScopeApi() {

    return SCOPE_API.equals(getScope());
  }

  /**
   * @return {@code true} if the {@link #getScope() scope} is {@link #SCOPE_BASE base}, {@code false} otherwise.
   */
  default boolean isScopeBase() {

    return SCOPE_BASE.equals(getScope());
  }

  /**
   * @return {@code true} if the {@link #getScope() scope} is {@link #SCOPE_IMPLEMENTATION impl}, {@code false}
   *         otherwise.
   */
  default boolean isScopeImpl() {

    return SCOPE_IMPLEMENTATION.equals(getScope());
  }

  /**
   * @return the name of the application. Will be the empty {@link String} if not {@link #isValid() valid}.
   */
  String getApplication();

  /**
   * @return the detail (suffix) of the package after the official segments specified by the architecture. Will be the
   *         empty {@link String} if not present. Otherwise it will include the leading dot (e.g. ".foo.bar").
   */
  String getDetail();

  /**
   * @param pkg1 the first package-fragment.
   * @param pkg2 the second package-fragment.
   * @return the package composed of the two given package-fragments.
   */
  static String composePackage(String pkg1, String pkg2) {

    if (pkg1 == null || pkg1.isEmpty()) {
      return pkg2;
    }

    if (pkg2 == null || pkg2.isEmpty()) {
      return pkg1;
    }

    return pkg1 + "." + pkg2;
  }

}
