package com.devonfw.ide.sonarqube.common.impl.check;

import java.io.File;

import org.sonar.plugins.java.api.JavaFileScannerContext;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.api.config.Configuration;
import com.devonfw.ide.sonarqube.common.impl.config.ConfigurationFactory;

/**
 * Abstract base class for a {@link DevonArchitectureCheck} that checks the business architecture (validates the
 * components and their dependencies).
 */
public abstract class DevonArchitectureComponentCheck extends DevonArchitectureCheck {

  private Configuration configuration;

  @Override
  public void scanFile(JavaFileScannerContext context) {

    File fileToScan = context.getFile();
    this.configuration = ConfigurationFactory.get(fileToScan);
    if (this.configuration == null) {
      this.configuration = new Configuration();
    }
    onConfigurationSet(context);
    super.scanFile(context);
  }

  /**
   * Called from {@link #scanFile(JavaFileScannerContext)} after the {@link Configuration} has been set.
   *
   * @param context the {@link JavaFileScannerContext}.
   */
  protected void onConfigurationSet(JavaFileScannerContext context) {

  }

  /**
   * @return the {@link Configuration} for the current project.
   */
  protected Configuration getConfiguration() {

    return this.configuration;
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

    String sourceComponentName = source.getComponent();
    String targetComponentName = target.getComponent();
    String sourceRoot = source.getRoot();
    String targetRoot = target.getRoot();
    String sourceApp = source.getApplication();
    String targetApp = target.getApplication();
    String prefix;
    if (sourceRoot.equals(targetRoot) && sourceApp.equals(targetApp)) {
      prefix = "";
    } else {
      prefix = targetRoot + "." + targetApp + ".";
    }
    if (sourceComponentName.equals(targetComponentName) && prefix.isEmpty()) {
      return null;
    }
    Component sourceComponent = getComponent(sourceComponentName);
    if (sourceComponent == null) {
      return null; // already covered by DevonArchitectureComponentDeclarationCheck.createIssueForInvalidSourcePackage
    }
    String targetName = prefix + targetComponentName;
    boolean targetDependencyAllowed = sourceComponent.hasDependency(targetName);
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
