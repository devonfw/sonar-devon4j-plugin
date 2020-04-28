package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyCheck;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that the {@code JPA} is properly used.
 */
@Rule(key = "E3", name = "devonfw 3rd Party JPA Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "thirdparty" })
public class DevonArchitecture3rdPartyJpaCheck extends DevonArchitecture3rdPartyCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (target.getPackage().startsWith("javax.persistence")) {
      if (source.isLayerDataAccess()) {
        return null;
      }
      if (source.isLayerCommon() && source.getSimpleName().contains("Embeddable")) {
        return null;
      }
      return "JPA (" + target + ") shall only be used in dataaccess layer or for embeddables in common.";
    }
    return null;
  }

}
