package com.devonfw.ide.sonarqube.common.impl.check;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that the {@code JPA} is properly used.
 */
@Rule(key = "Devon4j:E4", name = "Devon 3rd Party Hibernate Check", //
    description = "Verify that Hibernate is properly used (and JPA is preferred).", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitecture3rdPartyHibernateCheck extends DevonArchitecture3rdPartyCheck {

  private static final Set<String> DISCOURAGED_HIBERNATE_ANNOTATIONS = new HashSet<>(
      Arrays.asList("OrderBy", "Entity", "AccessType", "ForeignKey", "Cascade", "Index", "IndexColumn"));

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (target.getPackage().startsWith("org.hibernate") && !target.getPackage().startsWith("org.hibernate.validator")) {
      if (source.isLayerDataAccess()) {
        if (target.getPackage().equals("org.hibernate.annotations")) {
          if (DISCOURAGED_HIBERNATE_ANNOTATIONS.contains(target.getSimpleName())) {
            return "Standard JPA annotations should be used instead of this proprietary hibernate annotation (" + target
                + ").";
          }
        } else if (!source.isScopeImpl()) {
          return "Hibernate internals (" + target + ") should only be used in impl scope of dataaccess layer.";
        }
      } else {
        return "Hibernate (" + target + ") should only be used in dataaccess layer.";
      }
    }
    return null;
  }

}
