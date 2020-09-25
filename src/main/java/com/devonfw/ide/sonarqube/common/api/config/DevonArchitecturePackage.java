package com.devonfw.ide.sonarqube.common.api.config;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

public class DevonArchitecturePackage {

  private Devon4jPackage devon4jPackage;

  public DevonArchitecturePackage(String packageName) {

    this.devon4jPackage = Devon4jPackage.of(packageName);
  }

  public int getSegmentCount() {

    return this.devon4jPackage.getSegmentCount();
  }

  public String getSegment(int index) {

    return this.devon4jPackage.getSegment(index);
  }

  public boolean isValid() {

    return this.devon4jPackage.isValid();
  }

  public boolean isValidScope() {

    return this.devon4jPackage.isValidScope();
  }

  public boolean isValidLayer() {

    return this.devon4jPackage.isValidLayer();
  }

  public String getRoot() {

    return this.devon4jPackage.getRoot();
  }

  public String getApplication() {

    return this.devon4jPackage.getApplication();
  }

  public String getComponent() {

    return this.devon4jPackage.getComponent();
  }

  public String getLayer() {

    return this.devon4jPackage.getLayer();
  }

  public boolean isLayerCommon() {

    return this.devon4jPackage.isLayerCommon();
  }

  public boolean isLayerDataAccess() {

    return this.devon4jPackage.isLayerDataAccess();
  }

  public boolean isLayerLogic() {

    return this.devon4jPackage.isLayerLogic();
  }

  public boolean isLayerService() {

    return this.devon4jPackage.isLayerService();
  }

  public boolean isLayerBatch() {

    return this.devon4jPackage.isLayerBatch();
  }

  public boolean isLayerClient() {

    return this.devon4jPackage.isLayerClient();
  }

  public String getScope() {

    return this.devon4jPackage.getScope();
  }

  public boolean isScopeApi() {

    return this.devon4jPackage.isScopeApi();
  }

  public boolean isScopeBase() {

    return this.devon4jPackage.isScopeBase();
  }

  public boolean isScopeImpl() {

    return this.devon4jPackage.isScopeImpl();
  }

  public String getDetail() {

    return this.devon4jPackage.getDetail();
  }

  public int hashCode() {

    return this.devon4jPackage.hashCode();
  }

  public boolean equals(Object obj) {

    return this.devon4jPackage.equals(obj);
  }

  public String toString() {

    return this.devon4jPackage.toString();
  }

}