package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * @author ssabah
 *
 */

// is not a valid layer. Valid layers are: dataaccess,logic,service,batch,client or common

@Rule(key = "DevonArchitectureLayerLogicServiceCheck", name = "Devon Layer Logic-Service Check", description = "Verify valid layer, the code from Layer Logic does not call a code from Layer Service.", //
    priority = Priority.CRITICAL, tags = { "bug" })

public class DevonArchitectureLayerLogicServiceCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(Devon4jPackage source, Devon4jPackage target, String targetTypeSimpleName) {

    if (source.isLayerLogic() && target.isLayerService()) {
      return "Layer Logic ('" + source.toString() + "') shall not call from Layer Service ('" + target.toString()
          + "').";
    }
    return null;
  }

}
