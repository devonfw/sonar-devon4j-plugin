package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that {@literal @Transactional} is properly used from JEE.
 */
@Rule(key = "Devon4j:E1", name = "Devon 3rd Party Transactional Check", //
    description = "Verify that @Transactional is properly used from JEE.", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
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
