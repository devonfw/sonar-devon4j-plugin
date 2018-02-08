package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

/**
 * @author ssabah
 *
 */

// is not a valid layer. Valid layers are: dataaccess,logic,service,batch,client or common

@Rule(key = "DevonArchitectureLayerLogicServiceCheck", name = "Devon Layer Logic-Service Check", description = "Verify valid layer, the code from Layer Logic does not call a code from Layer Service.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerLogicServiceCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(OaspPackage source, OaspPackage target, String targetTypeSimpleName) {

    if (source.isLayerLogic() && target.isLayerService()) {
      return "Layer Logic ('" + source.toString() + "') shall not call from Layer Service ('" + target.toString()
          + "').";
    }
    return null;
  }

}
