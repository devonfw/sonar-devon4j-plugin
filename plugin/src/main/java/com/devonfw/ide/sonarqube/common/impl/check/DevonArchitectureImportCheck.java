package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;

/**
 * Super class for checks that need to make use of checkDependency()
 */
public abstract class DevonArchitectureImportCheck extends DevonArchitectureCheck {

  /**
   * @param tree Tree currently being investigated.
   * @param fileContext of analysis containing the parsed tree.
   */
  @Override
  protected void doScanFile(ClassTree tree, JavaFileScannerContext fileContext) {

  }

}
