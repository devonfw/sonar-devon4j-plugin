package com.devonfw.ide.sonarqube.common.impl.check;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import net.sf.mmm.util.reflect.api.ReflectionUtil;
import net.sf.mmm.util.reflect.base.ReflectionUtilImpl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TypeTree;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitecture3rdPartyCheck} ...
 */
@Rule(key = "Devon4j:E7", name = "Devon Uc Impl Security Constraint Check", //
    description = "Verify that all Use-Case implementation methods " //
        + "are annotated with a security constraint", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonUcImplSecurityConstraintCheck extends DevonArchitecture3rdPartyCheck {

  private static final Logger logger = Logger.getGlobal();

  /**
   * Method called after parsing and semantic analysis has been done on file.
   *
   * @param context Context of analysis containing the parsed tree.
   */
  @Override
  public void scanFile(JavaFileScannerContext context) {

    ReflectionUtil ru = getRU();
    ClassTree tree = getClassTree(context);
    TypeTree ucInterface = getUcInterface(tree);
    if (ucInterface == null)
      return;
    List<MethodTree> methodsOfTree = getMethodsOfTree(tree);

    logger.log(Level.INFO, "Name of UcInterface: " + ucInterface.toString());
  }

  /**
   * @return returns a bean of ReflectionUtil
   */
  public ReflectionUtil getRU() {

    return new ReflectionUtilImpl();
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

    String className = tree.simpleName().name();
    List<TypeTree> interfaces = tree.superInterfaces();
    Pattern interfaceRegEx = Pattern.compile(className.replaceAll("Impl", ""));

    if (interfaces.isEmpty()) {
      return null;
    }

    for (TypeTree interfaceTree : interfaces) {
      if (interfaceRegEx.matcher(interfaceTree.toString()).matches())
        return interfaceTree;
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
        MethodTree method = (MethodTree) member;
        methodsOfTree.add((MethodTree) member);
        logger.log(Level.INFO, "Method of class " + tree.simpleName().name() + ": " + method.simpleName().name());
      }
    }

    return methodsOfTree;
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
