package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;

import com.devonfw.ide.sonarqube.common.api.config.Architecture;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.api.config.Status;
import com.devonfw.module.basic.common.api.reflect.Devon4jPackage;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a {@link Component} itself is properly defined in
 * {@link Architecture} and that the general {@link Component#getDependencies() dependencies} are not violated.
 */
@Rule(key = "Devon4j:C1", name = "Devon Component Declaration Check", //
    description = "Verify component is properly declared in architecture.json file.", //
    priority = Priority.CRITICAL, tags = { "bug" })
public class DevonArchitectureComponentDeclarationCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String createIssueForInvalidSourcePackage(Devon4jPackage pkg, ClassTree classTree) {

    if (pkg.isValid()) {
      String sourceComponentName = pkg.getComponent();
      Component sourceComponent = getComponent(sourceComponentName);
      if (sourceComponent == null) {
        return "Undefined component '" + sourceComponentName
            + "' - please configure business architecture in architecture.json file.";
      }
    }
    return super.createIssueForInvalidSourcePackage(pkg, classTree);
  }

  @Override
  protected void onConfigurationSet(JavaFileScannerContext context) {

    super.onConfigurationSet(context);
    Status status = getConfiguration().status();
    if (!status.isErrorsReported()) {
      for (String error : status.getErrors()) {
        context.addIssue(0, this, error);
      }
      status.setErrorsReported();
    }
  }

  @Override
  protected String checkDependency(Devon4jPackage source, Component sourceComponent, Devon4jPackage target,
      String targetTypeSimpleName) {

    return null;
  }

}
