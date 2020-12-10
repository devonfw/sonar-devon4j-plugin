package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.api.config.DevonPackage;

/**
 * Abstract base class for a {@link DevonArchitectureCheck} that checks the business architecture (validates the
 * components and their dependencies).
 */
public abstract class DevonArchitectureComponentCheck extends DevonArchitectureCheck {

  @Override
  public void doScanFile(ClassTree tree, JavaFileScannerContext context) {

  }

  /**
   * @param name the {@link Component#getName() name} of the requested {@link Component}.
   * @return the requested {@link Component} or {@code null} if no such {@link Component} exists.
   */
  protected Component getComponent(String name) {

    return getConfiguration().getArchitecture().getComponent(name);
  }

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    DevonArchitecturePackage sourcePkg = source.getDevonPackage();
    DevonArchitecturePackage targetPkg = target.getDevonPackage();
    String sourceComponentName = sourcePkg.getComponent();
    String targetComponentName = targetPkg.getComponent();
    boolean sameRoot = sourcePkg.hasSameRoot(targetPkg);
    if (sourceComponentName.equals(targetComponentName) && sameRoot) {
      return null;
    }
    Component sourceComponent = getComponent(sourceComponentName);
    if (sourceComponent == null) {
      return null; // already covered by DevonArchitectureComponentDeclarationCheck.createIssueForInvalidSourcePackage
    }
    boolean targetDependencyAllowed;
    String targetName;
    if (sameRoot) {
      targetName = targetComponentName;
      targetDependencyAllowed = sourceComponent.hasDependency(targetName);
    } else {
      String targetRoot = targetPkg.getRoot();
      String targetRootApp = DevonPackage.composePackage(targetRoot, targetPkg.getApplication());
      targetName = DevonPackage.composePackage(targetRootApp, targetComponentName);
      targetDependencyAllowed = sourceComponent.hasDependency(targetRoot); // allow full access to (external) root?
      if (!targetDependencyAllowed) {
        targetDependencyAllowed = sourceComponent.hasDependency(targetRootApp); // allow full access to external app?
        if (!targetDependencyAllowed) {
          targetDependencyAllowed = sourceComponent.hasDependency(targetName); // allow access to external component?
        }
      }
    }
    if (!targetDependencyAllowed) {
      return targetDependencyNotAllowed(sourceComponent, targetName);
    }
    return checkDependency(source, sourceComponent, target);
  }

  /**
   * @param sourceComponent the {@link Component} of the source type to analyze.
   * @param targetComponentName the name of the dependent target {@link Component}.
   * @return the issue to create in case of a generally disallowed dependency or {@code null} for none.
   */
  protected String targetDependencyNotAllowed(Component sourceComponent, String targetComponentName) {

    return null;
  }

  /**
   * @param source the {@link JavaType} of the source type to analyze.
   * @param sourceComponent the {@link Component} of the source type to analyze.
   * @param target the {@link JavaType} of the dependent target type.
   * @return the issue to create in case of a disallowed dependency or {@code null} for none.
   */
  protected abstract String checkDependency(JavaType source, Component sourceComponent, JavaType target);

}
