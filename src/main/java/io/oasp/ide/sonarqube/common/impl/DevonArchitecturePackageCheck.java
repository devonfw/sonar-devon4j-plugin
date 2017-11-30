package io.oasp.ide.sonarqube.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.semantic.Symbol.TypeSymbol;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

@Rule(key = "DevonArchitecturePackageCheck", name = "Devon Package Check", description = "Verify that the code is following the devon package conventions.", //
    priority = Priority.MAJOR, tags = { "bug" })
public class DevonArchitecturePackageCheck extends BaseTreeVisitor implements JavaFileScanner {

  private List<String> issues;

  private String fullyQualifiedName;

  /**
   * The constructor.
   */
  public DevonArchitecturePackageCheck() {
    super();
    this.issues = new ArrayList<>();
  }

  /**
   * @return fullyQualifiedName
   */
  public String getFullyQualifiedName() {

    return this.fullyQualifiedName;
  }

  @Override
  public void scanFile(JavaFileScannerContext context) {

    this.issues.clear();
    scan(context.getTree());
    for (String issue : this.issues) {
      int lineNumber = 1;
      context.addIssue(lineNumber, this, issue);
    }
  }

  @Override
  public void visitIdentifier(IdentifierTree tree) {

    // TODO Auto-generated method stub
    super.visitIdentifier(tree);
  }

  @Override
  public void visitClass(ClassTree classTree) {
    // classTree.symbol().type().fullyQualifiedName()

    // String mySource = "" + JavaSymbol.TypeJavaSymbol.class.getProtectionDomain().getCodeSource();
    TypeSymbol symbol = classTree.symbol();
    // String theirSource = "" + symbol.getClass().getProtectionDomain().getCodeSource();

    this.fullyQualifiedName = classTree.symbol().type().fullyQualifiedName();
    String packageName = " ";

    int lastDot = this.fullyQualifiedName.lastIndexOf('.');
    if (lastDot > 0) {
      packageName = this.fullyQualifiedName.substring(0, lastDot);
    }
    if (packageName.isEmpty()) {
      this.issues.add("Invalid Package IS EMPTY!" + packageName + " !");
    } else {
      OaspPackage pkg = OaspPackage.of(packageName);
      if (!pkg.isValid()) {
        this.issues.add("Invalid Package IS VALID" + packageName + " !");
      }
    }
  }

}