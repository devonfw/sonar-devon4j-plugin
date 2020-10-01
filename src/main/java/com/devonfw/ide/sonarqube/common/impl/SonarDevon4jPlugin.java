package com.devonfw.ide.sonarqube.common.impl;

import org.sonar.api.Plugin;
import org.sonar.api.PropertyType;
import org.sonar.api.config.PropertyDefinition;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@link Plugin} to integrate devonfw architecture rules into SonarQube.
 */
public class SonarDevon4jPlugin implements Plugin {
  static final String CONFIG_KEY = "sonar.devon.config";

  static final String FORBIDDEN_CONF_KEY = "sonar.devon.forbiddenConf";

  static final String DISABLED = "Disabled";

  static final String ISSUES_SEVERITY_KEY = "sonar.Devon.preview.issuesSeverity";

  private static final String QUALINSIGHT = "qualinsight-plugins-sonarqube-smell-plugin";

  private static final String PMD = "sonar-pmd-plugin";

  private static final String CHECKSTYLE = "checkstyle-sonar-plugin";

  private static final String FINDBUGS = "sonar-findbugs-plugin";

  static List<String> FORBIDDEN_REPO_KEYS = new ArrayList<>();

  private File pluginDirectory;

  private List<String> pluginList;

  // Use this constructor only for testing purposes
  SonarDevon4jPlugin(File pluginDirectory) {

    this.pluginDirectory = pluginDirectory;
  }

  /**
   * The constructor
   */
  public SonarDevon4jPlugin() {

    this(new File("extensions/plugins"));
  }

  @Override
  public void define(Context context) {

    context.addExtensions(DevonSonarDefinition.class, DevonSonarRegistrar.class, DevonfwJavaProfile.class);
    context.addExtension(PropertyDefinition.builder(CONFIG_KEY).name("Config JSON")
        .description("Configuration of business architecture").category("devonfw").subCategory("")
        .type(PropertyType.TEXT)
        .defaultValue("{\"architecture\":{\"components\":[\n{\"name\":\"component1\",\\\"dependencies\\\":[]}}\n]}}")
        .build());
    context.addExtension(PropertyDefinition.builder(DISABLED).name("Warning")
        .description("Missing plugins for full initialization of devonfw quality profile").category("devonfw")
        .subCategory("").type(PropertyType.TEXT).defaultValue(getMissingPlugins()).build());
    disableRepoKeys();
  }

  private List<String> getPlugins() {

    if (this.pluginList == null) {
      File[] fileList = this.pluginDirectory.listFiles(f -> f.getName().endsWith(".jar") && f.isFile());
      this.pluginList = Arrays.asList(fileList).stream().map(f -> f.getName()).collect(Collectors.toList());
    }
    return this.pluginList;
  }

  private boolean hasPlugin(String name) {

    for (String plugin : getPlugins()) {
      if (plugin.contains(name)) {
        return true;
      }
    }
    return false;
  }

  private void disableRepoKeys() {

    if (!hasPlugin(QUALINSIGHT)) {
      FORBIDDEN_REPO_KEYS.add("qualinsight-smells");
    }
    if (!hasPlugin(PMD)) {
      FORBIDDEN_REPO_KEYS.add("pmd");
      FORBIDDEN_REPO_KEYS.add("pmd-unit-tests");
    }
    if (!hasPlugin(CHECKSTYLE)) {
      FORBIDDEN_REPO_KEYS.add("checkstyle");
    }
    if (!hasPlugin(FINDBUGS)) {
      FORBIDDEN_REPO_KEYS.add("findbugs");
      FORBIDDEN_REPO_KEYS.add("findsecbugs");
      FORBIDDEN_REPO_KEYS.add("fb-contrib");
    }
  }

  private String getMissingPlugins() {

    StringBuilder missingPlugins = new StringBuilder();
    List<String> requiredPlugins = Arrays.asList(QUALINSIGHT, CHECKSTYLE, PMD, FINDBUGS);
    requiredPlugins.forEach(requiredPlugin -> {
      if (!hasPlugin(requiredPlugin)) {
        missingPlugins.append("- " + requiredPlugin + "\n");
      }
    });
    if (missingPlugins.length() != 0) {
      missingPlugins.insert(0, "Please install plugins listed below: \n\n");
    } else {
      missingPlugins.append("All plugins installed properly");
    }
    return missingPlugins.toString();
  }
}