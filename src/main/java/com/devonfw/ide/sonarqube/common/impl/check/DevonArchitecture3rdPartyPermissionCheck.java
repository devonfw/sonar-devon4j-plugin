package com.devonfw.ide.sonarqube.common.impl.check;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;

import net.sf.mmm.util.reflect.api.ReflectionUtil;
import net.sf.mmm.util.reflect.base.ReflectionUtilImpl;

/**
 * {@link DevonArchitecture3rdPartyCheck} ...
 */
@Rule(key = "Devon4j:E7", name = "Devon 3rd Party Permission Check", //
    description = "Verify that all Use-Case implementation methods " //
                + "are annotated with a security constraint", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonArchitecture3rdPartyPermissionCheck extends DevonArchitecture3rdPartyCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    Logger logger = Logger.getLogger("Logger");

    if (!source.isScopeImpl()) return null;

    ReflectionUtil ru = ReflectionUtilImpl.getInstance();
    Method[] declaredMethods = source.getClass().getDeclaredMethods();

    for(Method method : declaredMethods) {

      Method parentMethod = ru.getParentMethod(method);

      logger.log(Level.INFO, parentMethod.toString());

      if(parentMethod == null) return null;
      else {

        Class<?> declaringClass = parentMethod.getDeclaringClass();

        logger.log(Level.INFO, declaringClass.getName());

        if(declaringClass.isInterface() &&
           method.getAnnotation(RolesAllowed.class) == null &&
           method.getAnnotation(PermitAll.class) == null &&
           method.getAnnotation(DenyAll.class) == null) {

          /*
          try {
            method.getAnnotation(RolesAllowed.class);
            return null;
          } catch(NullPointerException ex) {}
          try {
            method.getAnnotation(PermitAll.class);
            return null;
          } catch(NullPointerException ex) {}
          try {
            method.getAnnotation(DenyAll.class);
            return null;
          } catch(NullPointerException ex) {}
          */

          return "Please annotate all methods implementing public API methods from Use-Case interfaces with "
              +  "security constraints (@DenyAll, @PermitAll, @RolesAllowed)";
        } else return null;
      }
    }

      /*
      if((method.getAnnotation(javax.annotation.security.DenyAll.class) == null) &&
         (method.getAnnotation(javax.annotation.security.PermitAll.class) == null) &&
         (method.getAnnotation(javax.annotation.security.RolesAllowed.class) == null)) {
        return "Please annotate all methods implementing public API methods from Use-Case interfaces with "
            +  "security constraints (@DenyAll, @PermitAll, @RolesAllowed)";
      }
      */

      /*
      if(!(Arrays.toString(method.getClass().getAnnotations()).contains("javax.annotation.security.DenyAll")) &&
         !(Arrays.toString(method.getClass().getAnnotations()).contains("javax.annotation.security.PermitAll")) &&
         !(Arrays.toString(method.getClass().getAnnotations()).contains("javax.annotation.security.RolesAllowed"))) {
        return "Please annotate all methods implementing public API methods from Use-Case interfaces with "
            +  "security constraints (@DenyAll, @PermitAll, @RolesAllowed)";
      }
      */




    /*
    if (source.isScopeImpl() && !(target.toString().equals("javax.annotation.security.DenyAll") ||
                                  target.toString().equals("javax.annotation.security.PermitAll") ||
                                  target.toString().equals("javax.annotation.security.RolesAllowed"))) {
      return "Please annotate all methods implementing public API methods from Use-Case interfaces with "
          +  "security constraints (@DenyAll, @PermitAll, @RolesAllowed)";
    }
    */

    return null;

  }
}
