package com.devonfw.ide.sonarqube.common.impl.check.thirdparty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitecture3rdPartyCheck;

/**
 * {@link DevonArchitecture3rdPartyCheck} verifying that the {@code JPA} is properly used.
 */
@Rule(key = "E4", name = "devonfw 3rd Party Hibernate Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "thirdparty" })
public class DevonArchitecture3rdPartyHibernateCheck extends DevonArchitecture3rdPartyCheck {

  private static final Set<String> DISCOURAGED_HIBERNATE_ANNOTATIONS = new HashSet<>(
      Arrays.asList("OrderBy", "Entity", "AccessType", "ForeignKey", "Cascade", "Index", "IndexColumn"));

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    String targetSimpleName = target.getSimpleName();
    String targetPackageName = target.getPackage();

    if (targetPackageName.startsWith("org.hibernate") && !targetPackageName.startsWith("org.hibernate.validator")) {

      if (!source.isLayerDataAccess()) {
        return "Hibernate (" + target + ") should only be used in dataaccess layer.";
      }

      if (isUsingProprietaryHibernateAnnotation(targetSimpleName, targetPackageName)) {
        return "Standard JPA annotations should be used instead of this proprietary hibernate annotation (" + target
            + ").";
      }

      if (targetPackageName.startsWith("org.hibernate.envers")) {

        if (isNotImplementingHibernateEnversInImplScope(source, targetSimpleName, targetPackageName)) {
          return "Hibernate envers implementation (" + target
              + ") should only be used in impl scope of dataaccess layer.";
        }

        if (targetPackageName.contains("internal")) {
          return "Hibernate envers internals (" + target + ") should never be used directly.";
        }

      }

      if (!source.isScopeImpl()) {
        return "Hibernate internals (" + target + ") should only be used in impl scope of dataaccess layer.";
      }

    }

    return null;

  }

  private boolean isUsingProprietaryHibernateAnnotation(String targetSimpleName, String targetPackageName) {

    return targetPackageName.equals("org.hibernate.annotations")
        && DISCOURAGED_HIBERNATE_ANNOTATIONS.contains(targetSimpleName);
  }

  private boolean isNotImplementingHibernateEnversInImplScope(JavaType source, String targetSimpleName,
      String targetPackageName) {

    return !source.isScopeImpl()
        && (!targetPackageName.equals("org.hibernate.envers") || targetSimpleName.startsWith("Default")
            || targetSimpleName.contains("Listener") || targetSimpleName.contains("Reader"));
  }

}
