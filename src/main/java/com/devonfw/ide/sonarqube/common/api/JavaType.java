package com.devonfw.ide.sonarqube.common.api;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * Simple representation of a Java type.
 */
public class JavaType {

  private final Devon4jPackage pkg;

  private final String simpleName;

  /**
   * The constructor.
   *
   * @param pkg
   * @param simpleName
   */
  public JavaType(Devon4jPackage pkg, String simpleName) {

    super();
    this.pkg = pkg;
    this.simpleName = simpleName;
  }

  /**
   * @return simpleName
   */
  public String getSimpleName() {

    return this.simpleName;
  }

  public String getPackage() {

    return this.pkg.toString();
  }

  public String getRoot() {

    return this.pkg.getRoot();
  }

  public String getApplication() {

    return this.pkg.getApplication();
  }

  public String getComponent() {

    return this.pkg.getComponent();
  }

  public String getLayer() {

    return this.pkg.getLayer();
  }

  public String getScope() {

    return this.pkg.getScope();
  }

  public boolean isScopeApi() {

    return this.pkg.isScopeApi();
  }

  public boolean isScopeBase() {

    return this.pkg.isScopeBase();
  }

  public boolean isScopeImpl() {

    return this.pkg.isScopeImpl();
  }

  public boolean isLayerBatch() {

    return this.pkg.isLayerBatch();
  }

  public boolean isLayerClient() {

    return this.pkg.isLayerClient();
  }

  public boolean isLayerCommon() {

    return this.pkg.isLayerCommon();
  }

  public boolean isLayerDataAccess() {

    return this.pkg.isLayerDataAccess();
  }

  public boolean isLayerLogic() {

    return this.pkg.isLayerLogic();
  }

  public boolean isLayerService() {

    return this.pkg.isLayerService();
  }

  public boolean isValid() {

    return this.pkg.isValid();
  }

  public boolean isValidLayer() {

    return this.pkg.isValidLayer();
  }

  public boolean isValidScope() {

    return this.pkg.isValidScope();
  }

  @Override
  public String toString() {

    String pkgName = this.pkg.toString();
    if (this.simpleName == null) {
      return pkgName;
    } else if (pkgName.isEmpty()) {
      return this.simpleName;
    } else {
      return pkgName + "." + this.simpleName;
    }
  }

}
