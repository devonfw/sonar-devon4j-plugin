package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyCheck;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that the {@code JPA} is properly used.
 */
@Rule(key = "E4")
public class DevonArchitecture3rdPartyHibernateCheck extends DevonArchitecture3rdPartyCheck {

  private static final Set<String> DISCOURAGED_HIBERNATE_ANNOTATIONS = new HashSet<>(
      Arrays.asList("OrderBy", "Entity", "AccessType", "ForeignKey", "Cascade", "Index", "IndexColumn"));

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (target.getPackage().startsWith("org.hibernate") && !target.getPackage().startsWith("org.hibernate.validator")) {
      if (source.isLayerDataAccess()) {
        String targetSimpleName = target.getSimpleName();
        if (target.getPackage().equals("org.hibernate.annotations")) {
          if (DISCOURAGED_HIBERNATE_ANNOTATIONS.contains(targetSimpleName)) {
            return "Standard JPA annotations should be used instead of this proprietary hibernate annotation (" + target
                + ").";
          }
        } else if (target.getPackage().startsWith("org.hibernate.envers")) {
          if (!source.isScopeImpl()) {
            if (!target.getPackage().equals("org.hibernate.envers") || targetSimpleName.startsWith("Default")
                || targetSimpleName.contains("Listener") || targetSimpleName.contains("Reader")) {
              return "Hibernate envers implementation (" + target
                  + ") should only be used in impl scope of dataaccess layer.";
            }
          } else if (target.getPackage().contains("internal")) {
            return "Hibernate envers internals (" + target + ") should never be used directly.";
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
