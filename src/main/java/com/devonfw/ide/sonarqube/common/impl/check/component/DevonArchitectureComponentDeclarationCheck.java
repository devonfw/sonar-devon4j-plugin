package com.devonfw.ide.sonarqube.common.impl.check.component;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Architecture;
import com.devonfw.ide.sonarqube.common.api.config.Component;
import com.devonfw.ide.sonarqube.common.api.config.Status;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureComponentCheck;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a {@link Component} itself is properly defined in
 * {@link Architecture} and that the general {@link Component#getDependencies() dependencies} are not violated.
 */
// @Rule(key = "Devon4j:C1", name = "Devon Component Declaration Check", //
// description = "Verify component is properly declared in architecture.json file.", //
// priority = Priority.CRITICAL, tags = { "architecture-violation", "devonfw", "component" })
@Rule(key = "C1", name = "Devon Component Declaration Check")
public class DevonArchitectureComponentDeclarationCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String createIssueForInvalidSourcePackage(JavaType source, ClassTree classTree) {

    if (source.isValid()) {
      String sourceComponentName = source.getComponent();
      Component sourceComponent = getComponent(sourceComponentName);
      if (sourceComponent == null) {
        return "Undefined component '" + sourceComponentName
            + "' - please configure business architecture in architecture.json file.";
      }
    }
    return super.createIssueForInvalidSourcePackage(source, classTree);
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
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    return null;
  }

}
