package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that datatypes are properly mapped
 * @author lniazman
 *
 */
@Rule(key = "Devon4j:E6", name = "Devon 3rd Party Datatype Mappings Check", //
	description = "Verify that datatypes are mapped to the JPA using the correct annotation", //
	priority = Priority.CRITICAL, tags = { "test-tag" }) //
public class DevonArchitecture3rdPartyDatatypeMappingsCheck extends DevonArchitecture3rdPartyCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

	if (target.toString().equals("org.hibernate.Type")) {
      return "Use the javax.persistence.Converter annotation on a custom converter "
      	   + "which implements the javax.persistence.AttributeConverter "
      	   + "instead of the org.hibernate.Type annotation";
	} else if (target.toString().equals("javax.persistence.Convert")) {
	  return "Use the javax.persistence.Converter annotation on a custom converter "
	       + "which implements the javax.persistence.AttributeConverter "
	       + "instead of the javax.persistence.Convert annotation";
	}

	return null;
  }

}
