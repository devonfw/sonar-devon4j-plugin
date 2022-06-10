package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyCheck;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that datatypes are properly mapped
 *
 * @author lniazman
 *
 */
@Rule(key = "E6", name = "devonfw 3rd Party Datatype Mappings Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "thirdparty" })
public class DevonArchitecture3rdPartyDatatypeMappingsCheck extends DevonArchitecture3rdPartyCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    String targetFqn = target.getQualifiedName();

    if (targetFqn.equals("org.hibernate.Type") || targetFqn.equals("javax.persistence.Convert")) {
      return "Use the javax.persistence.Converter annotation on a custom converter"
          + " which implements the javax.persistence.AttributeConverter instead of the " + targetFqn + " annotation";
    }

    return null;
  }

}
