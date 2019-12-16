package com.devonfw.ide.sonarqube.common.impl.check.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TypeTree;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} verifies that all Use-Case implementation methods are annotated with a security
 * constraint from javax.annotation.security.
 */
@Rule(key = "Y1", name = "Devon Uc Impl Security Constraint Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "security" })
public class DevonUcImplSecurityConstraintCheck extends DevonArchitectureCheck {

  private static final Set<String> REQUIRED_ANNOTATIONS = new HashSet<>(
      Arrays.asList("DenyAll", "PermitAll", "RolesAllowed"));

  @Override
  public void scanFile(JavaFileScannerContext context) {

    ClassTree tree = getClassTree(context);
    TypeTree ucInterface = getUcInterface(tree);

    if (ucInterface == null) {
      return;
    }

    List<MethodTree> methodsOfTree = getMethodsOfTree(tree);
    for (MethodTree method : methodsOfTree) {
      if (isMethodPublic(method) && !isMethodProperlyAnnotated(method)) {
        context.reportIssue(this, method,
            "This method is not properly annotated. "
                + "Please use one of the following annotations on Use-Case implementation methods: "
                + REQUIRED_ANNOTATIONS.toString());
      }
    }
  }

  /**
   * @param context of analysis containing the parsed tree.
   * @return ClassTree instance.
   */
  protected ClassTree getClassTree(JavaFileScannerContext context) {

    CompilationUnitTree parsedTree = context.getTree();
    List<Tree> types = parsedTree.types();

    for (Tree tree : types) {
      if (tree instanceof ClassTree) {
        return (ClassTree) tree;
      }
    }

    return null;
  }

  /**
   * Returns the Uc interface implemented by the checked class, if there is one.
   *
   * @param tree currently being investigated.
   * @return TypeTree instance of the Uc interface.
   */
  protected TypeTree getUcInterface(ClassTree tree) {

    List<TypeTree> interfaces = tree.superInterfaces();

    if (interfaces.isEmpty()) {
      return null;
    }

    String className = tree.simpleName().name();
    String interfaceName = className.replace("Impl", "");

    for (TypeTree interfaceTree : interfaces) {
      if (interfaceTree.toString().equals(interfaceName)) {
        return interfaceTree;
      }
    }

    return null;
  }

  /**
   * Checks if a method with an override annotation also has one of the required security annotations.
   *
   * @param method to be checked
   * @return true or false depending on whether method is properly annotated or not
   */
  private boolean isMethodProperlyAnnotated(MethodTree method) {

    List<AnnotationTree> annotationsOfMethod = method.modifiers().annotations();
    boolean hasOverrideAnnotation = false;
    boolean hasRequiredAnnotation = false;

    for (AnnotationTree annotation : annotationsOfMethod) {

      String annotationType = annotation.annotationType().toString();

      if (annotationType.equals("Override")) {
        hasOverrideAnnotation = true;
      }

      if (REQUIRED_ANNOTATIONS.contains(annotationType)) {
        hasRequiredAnnotation = true;
      }

    }

    return ((!hasOverrideAnnotation) || (hasOverrideAnnotation && hasRequiredAnnotation));
  }

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

}
