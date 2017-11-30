package io.oasp.ide.sonarqube.common.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * Rule to verify code dependencies regarding Devon architecture.
 */
public class ArchitectureRule {

  private static final Logger LOG = LoggerFactory.getLogger(ArchitectureRule.class);

  public boolean verifyDependency(Class<?> source, Class<?> destination) {

    OaspPackage sourcePkg = OaspPackage.of(source);
    OaspPackage destPkg = OaspPackage.of(destination);
    if (!sourcePkg.isValid()) {
      LOG.warn("Package of source {} is invalid.", source);
    }
    if (!destPkg.isValidLayer() || !destPkg.isValidScope()) {
      LOG.debug("Package of destination {} is invalid - ignoring dependency.", destination);
      return true;
    }
    if (sourcePkg.isValidScope() && destPkg.isValidScope()) {
      boolean valid = verifyDependencyScope(sourcePkg, destPkg);
      if (!valid) {
        LOG.warn("Invalid scope dependency from {} to {}.", sourcePkg.getScope(), destPkg.getScope());
        return false;
      }
    }
    if (sourcePkg.isValidLayer() && destPkg.isValidLayer()) {
      boolean valid = verifyDependencyLayer(sourcePkg, destPkg);
      if (!valid) {
        LOG.warn("Invalid layer dependency from {} to {}.", sourcePkg.getLayer(), destPkg.getLayer());
        return false;
      }
    }
    return true;
  }

  private boolean verifyDependencyScope(OaspPackage sourcePkg, OaspPackage destPkg) {

    if (sourcePkg.isScopeApi()) {
      return destPkg.isScopeApi();
    } else if (sourcePkg.isScopeBase()) {
      return !destPkg.isScopeImpl();
    }
    return true;
  }

  private boolean verifyDependencyLayer(OaspPackage sourcePkg, OaspPackage destPkg) {

    if (sourcePkg.getLayer().equals(destPkg.getLayer())) {
      return true;
    }
    if (!sourcePkg.getComponent().equals(destPkg.getComponent())) {
      return false;
    }
    if (sourcePkg.isLayerService()) {
      return destPkg.isLayerLogic();
    } else if (sourcePkg.isLayerBatch()) {
      return destPkg.isLayerLogic();
    } else if (sourcePkg.isLayerLogic()) {
      return destPkg.isLayerDataAccess();
    } else if (sourcePkg.isLayerDataAccess()) {
      return false;
    }
    return false;
  }

}