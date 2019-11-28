package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyCheck;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that {@literal @Transactional} is properly used from JEE.
 */
@Rule(key = "E1", name = "Devon 3rd Party Transactional Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "thirdparty" })
public class DevonArchitecture3rdPartyTransactionalCheck extends DevonArchitecture3rdPartyCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (target.toString().equals("org.springframework.transaction.annotation.Transactional")) {
      return "Use JEE standard (javax.transaction.Transactional from javax.transaction:javax.transaction-api:1.2+).";
    }
    if (source.isScopeApi() && target.toString().equals("javax.transaction.Transactional")) {
      return "Use @Transactional not in API but to annotate implementations.";
    }
    return null;
  }

}
