package com.devonfw.ide.sonarqube.common.impl.check;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.mmm.util.reflect.api.ReflectionUtil;
import net.sf.mmm.util.reflect.base.ReflectionUtilImpl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.Tree;

import com.devonfw.ide.sonarqube.common.api.JavaType;

/**
 * {@link DevonArchitecture3rdPartyCheck} ...
 */
@Rule(key = "Devon4j:E7", name = "Devon Uc Impl Security Constraint Check", //
    description = "Verify that all Use-Case implementation methods " //
        + "are annotated with a security constraint", //
    priority = Priority.CRITICAL, tags = { "architecture-violation" })
public class DevonUcImplSecurityConstraintCheck extends DevonArchitecture3rdPartyCheck {

  /**
   *
   */
  @Override
  protected String checkDependency(final JavaType source, final JavaType target) {

    Logger logger = Logger.getLogger("Logger");
    // String packageName = source.getPackage();

    if (!source.isScopeImpl())
      return null;

    Class<?> clazz;

    logger.log(Level.INFO, "Class name: " + source.toString());

    try {
      clazz = Class.forName(source.getSimpleName());
    } catch (ClassNotFoundException e) {
      logger.log(Level.INFO, "Class was not found.");
    }

    // logger.log(Level.INFO, target.toString());
    //
    // ReflectionUtil ru = getRU();
    //
    // logger.log(Level.INFO, "Source package: " + source.getPackage());
    //
    // Set<String> classNames = ru.findClassNames(source.getPackage(), true);
    // logger.log(Level.INFO, "Is classNames set empty? " + classNames.isEmpty());
    // Set<Class<?>> classes = ru.loadClasses(classNames);
    // logger.log(Level.INFO, "Is classes set empty? " + classes.isEmpty());
    //
    // // logger.log(Level.INFO,
    // // "Package: " + packageName + ", Class name: " + source.getSimpleName() + ", " + source.toString());
    // // logger.log(Level.INFO, "classNames is empty: " + classNames.isEmpty());
    //
    // // Set<Class<?>> classes = ru.loadClasses(classNames);
    //
    // for (Class<?> clazz : classes) {
    //
    // logger.log(Level.INFO, "Current class: " + clazz.toString());
    //
    // Method[] declaredMethods = clazz.getDeclaredMethods();
    //
    // for (Method method : declaredMethods) {
    //
    // logger.log(Level.INFO, "Current method: " + method.toString());
    //
    // Method parentMethod = ru.getParentMethod(method);
    //
    // logger.log(Level.INFO, parentMethod.toString());
    //
    // if (parentMethod != null) {
    //
    // Class<?> declaringClass = parentMethod.getDeclaringClass();
    //
    // logger.log(Level.INFO, "Declaring class of current method: " + declaringClass.getName());
    //
    // if (declaringClass.isInterface() && method.getAnnotation(RolesAllowed.class) == null
    // && method.getAnnotation(PermitAll.class) == null && method.getAnnotation(DenyAll.class) == null) {
    //
    // /*
    // * try { method.getAnnotation(RolesAllowed.class); return null; } catch(NullPointerException ex) {} try {
    // * method.getAnnotation(PermitAll.class); return null; } catch(NullPointerException ex) {} try {
    // * method.getAnnotation(DenyAll.class); return null; } catch(NullPointerException ex) {}
    // */
    //
    // return "Please annotate all methods implementing public API methods from Use-Case interfaces with "
    // + "security constraints (@DenyAll, @PermitAll, @RolesAllowed)";
    // } else {
    // return null;
    // }
    // }
    // }
    // }

    return null;
  }

  /**
  *
  */
  // @Override
  // public void scanFile(JavaFileScannerContext context) {
  //
  // Logger logger = Logger.getLogger("logger");
  // Class<?> clazz;
  //
  // ClassTree tree = getClassTree(context);
  // logger.log(Level.INFO, tree.simpleName().toString());
  // try {
  // clazz = Class.forName(tree.simpleName().name());
  // } catch (ClassNotFoundException e) {
  // return;
  // }
  //
  // logger.log(Level.INFO, "Class name from clazz: " + clazz.getSimpleName());
  // logger.log(Level.INFO, "Class name: " + tree.simpleName().name());
  //
  // // TypeTree superInterface = tree.superInterfaces().get(0);
  // //
  // // logger.log(Level.INFO, "Super interface name: " + superInterface.toString());
  // //
  // // for (Tree member : tree.members()) {
  // // if (member.kind().equals(Kind.METHOD)) {
  // // logger.log(Level.INFO, "Super interface kind toString: " + superInterface.kind().toString()
  // // + "; member toString: " + member.toString());
  // // if (superInterface.toString().contains(member.toString())) {
  // //
  // // }
  // // }
  // // }
  //
  // }

  /**
   * @param context Context on analysis containing the parsed tree.
   * @return Returns class tree.
   */
  public ClassTree getClassTree(JavaFileScannerContext context) {

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
   * Method called after parsing and semantic analysis has been done on file.
   *
   * @param context Context of analysis containing the parsed tree.
   */
  @Override
  public void scanFile(JavaFileScannerContext context) {

    Logger logger = Logger.getLogger("logger");
    ClassTree tree = getClassTree(context);

    if (tree.superInterfaces().isEmpty())
      return;

  }

  /**
   * @return returns a bean of ReflectionUtil
   */
  public ReflectionUtil getRU() {

    return new ReflectionUtilImpl();
  }

}
