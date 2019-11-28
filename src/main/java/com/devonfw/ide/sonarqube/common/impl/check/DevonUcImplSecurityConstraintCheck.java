package com.devonfw.ide.sonarqube.common.impl.check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

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

/**
 * {@link DevonArchitecture3rdPartyCheck} verifies that all Use-Case implementation methods are annotated with a
 * security constraint from javax.annotation.security.
 */
@Rule(key = "E7", name = "Devon Uc Impl Security Constraint Check", //
    priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw" })
public class DevonUcImplSecurityConstraintCheck extends DevonArchitectureCheck {

  private static final Set<String> REQUIRED_ANNOTATIONS = new HashSet<>(
      Arrays.asList("DenyAll", "PermitAll", "RolesAllowed"));

  /**
   * Method called after parsing and semantic analysis has been done on file.
   *
   * @param context Context of analysis containing the parsed tree.
   */
  @Override
  public void scanFile(JavaFileScannerContext context) {

    ClassTree tree = getClassTree(context);
    TypeTree ucInterface = getUcInterface(tree);

    if (ucInterface == null) {
      return;
    }

    List<MethodTree> methodsOfTree = getMethodsOfTree(tree);
    for (MethodTree method : methodsOfTree) {
      if (!isMethodProperlyAnnotated(method)) {
        context.reportIssue(this, method,
            "This method is not properly annotated. "
                + "Please use one of the following annotations on Use-Case implementation methods: "
                + REQUIRED_ANNOTATIONS.toString());
      }
    }
  }

  /**
   * @param context Context of analysis containing the parsed tree.
   * @return Class tree.
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
   * @param tree Tree currently being investigated.
   * @return TypeTree instance of the Uc interface.
   */
  protected TypeTree getUcInterface(ClassTree tree) {

    List<TypeTree> interfaces = tree.superInterfaces();
    String className = tree.simpleName().name();
    Pattern interfaceRegEx = Pattern.compile(className.replaceAll("Impl", ""));

    if (interfaces.isEmpty()) {
      return null;
    }

    for (TypeTree interfaceTree : interfaces) {
      if (interfaceRegEx.matcher(interfaceTree.toString()).matches()) {
        return interfaceTree;
      }
    }

    return null;
  }

  /**
   * Returns all methods of the given tree.
   *
   * @param tree Tree currently being investigated.
   * @return List of MethodTree.
   */
  protected List<MethodTree> getMethodsOfTree(ClassTree tree) {

    List<Tree> membersOfTree = tree.members();
    List<MethodTree> methodsOfTree = new ArrayList<>();

    for (Tree member : membersOfTree) {
      if (member.is(Tree.Kind.METHOD)) {
        methodsOfTree.add((MethodTree) member);
      }
    }

    return methodsOfTree;
  }

  private boolean isMethodProperlyAnnotated(MethodTree method) {

    List<AnnotationTree> annotationsOfMethod = method.modifiers().annotations();
    boolean hasOverrideAnnotation = false;
    boolean hasRequiredAnnotation = false;

    for (AnnotationTree annotation : annotationsOfMethod) {
      if (annotation.annotationType().toString().equals("Override")) {
        hasOverrideAnnotation = true;
      }

      if (REQUIRED_ANNOTATIONS.contains(annotation.annotationType().toString())) {
        hasRequiredAnnotation = true;
      }
    }

    if ((!hasOverrideAnnotation) || (hasOverrideAnnotation && hasRequiredAnnotation)) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Called in case of a dependency that is devonfw compliant.
   *
   * @param source the {@link JavaType} to analyze.
   * @param target the {@link JavaType} used by the source type (as dependency).
   * @return the message of an issue to create due to an undesired dependency or {@code null} if dependency is fine.
   */
  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    return null;
  }

}
