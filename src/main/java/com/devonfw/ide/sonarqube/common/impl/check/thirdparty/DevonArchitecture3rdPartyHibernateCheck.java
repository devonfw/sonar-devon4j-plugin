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

  private static final String ORG_HIBERNATE_ENVERS = "org.hibernate.envers";

  private static final String ORG_HIBERNATE_VALIDATOR = "org.hibernate.validator";

  private static final String ORG_HIBERNATE_ANNOTATIONS = "org.hibernate.annotations";

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    String targetSimpleName = target.getSimpleName();
    String targetPackageName = target.getPackage();

    if (targetPackageName.startsWith("org.hibernate") && !targetPackageName.startsWith(ORG_HIBERNATE_VALIDATOR)) {

      if (!source.isLayerDataAccess()) {
        return "Hibernate (" + target + ") should only be used in dataaccess layer.";
      }

      if (isUsingProprietaryHibernateAnnotation(targetSimpleName, targetPackageName)) {
        return "Standard JPA annotations should be used instead of this proprietary hibernate annotation (" + target
            + ").";
      }

      if (isNotImplementingHibernateEnversInImplScope(source, targetSimpleName, targetPackageName)) {
        return "Hibernate envers implementation (" + target
            + ") should only be used in impl scope of dataaccess layer.";
      }

      if (isImplementingHibernateEnversInternalsDirectly(targetPackageName)) {
        return "Hibernate envers internals (" + target + ") should never be used directly.";
      }

      if (!source.isScopeImpl()) {
        return "Hibernate internals (" + target + ") should only be used in impl scope of dataaccess layer.";
      }

    }

    return null;

  }

  private boolean isUsingProprietaryHibernateAnnotation(String targetSimpleName, String targetPackageName) {

    return targetPackageName.equals(ORG_HIBERNATE_ANNOTATIONS)
        && DISCOURAGED_HIBERNATE_ANNOTATIONS.contains(targetSimpleName);
  }

  private boolean isNotImplementingHibernateEnversInImplScope(JavaType source, String targetSimpleName,
      String targetPackageName) {

    return (targetPackageName.startsWith(ORG_HIBERNATE_ENVERS)) && !source.isScopeImpl()
        && (!targetPackageName.equals(ORG_HIBERNATE_ENVERS) || targetSimpleName.startsWith("Default")
            || targetSimpleName.contains("Listener") || targetSimpleName.contains("Reader"));
  }

  private boolean isImplementingHibernateEnversInternalsDirectly(String targetPackageName) {

    return targetPackageName.startsWith(ORG_HIBERNATE_ENVERS) && targetPackageName.contains("internal");
  }

}
