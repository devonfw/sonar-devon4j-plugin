package com.devonfw.ide.sonarqube.common.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.plugins.java.Java;
import org.sonarsource.api.sonarlint.SonarLintSide;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * This class creates a quality profile containing the rules of this plugin plus additional rules from external repos.
 */
@SonarLintSide
public class DevonfwJavaProfile implements BuiltInQualityProfilesDefinition {

  private static final String DEVONFW_JAVA = "/com/devonfw/ide/sonarqube/common/rules/devon4j/devonfwJava.xml";

  private static final Logger logger = Logger.getGlobal();

  private static final Runtime HOST_ENVIRONMENT = Runtime.getRuntime();

  private static final String QUALINSIGHT = "qualinsight-plugins-sonarqube-smell-plugin";

  private static final String PMD = "sonar-pmd-plugin";

  private static final String CHECKSTYLE = "checkstyle-sonar-plugin";

  private static final String FINDBUGS = "sonar-findbugs-plugin";

  private static List<String> FORBIDDEN_REPO_KEYS = new ArrayList<>();

  private boolean testEnv = false;

  // Use this constructor only for testing purposes
  DevonfwJavaProfile(boolean testEnv) {

    this.testEnv = testEnv;
  }

  /**
   * The constructor
   */
  public DevonfwJavaProfile() {

  }

  @Override
  public void define(Context context) {

    NewBuiltInQualityProfile devonfwJava = context.createBuiltInQualityProfile("devonfw Java", Java.KEY);
    Document parsedXml = readQualityProfileXml();
    if (parsedXml == null) {
      logger.log(Level.INFO, "The XML file could not be read.");
      return;
    }
    NodeList ruleList = parsedXml.getElementsByTagName("rule");
    NodeList childrenOfRule;
    List<String> pluginList = getPlugins();
    disableRepoKeys(pluginList);

    NewBuiltInActiveRule currentRule;
    String repoKey = null;
    String ruleKey = null;
    String severity = null;

    for (int i = 0; i < ruleList.getLength(); i++) {

      childrenOfRule = ruleList.item(i).getChildNodes();

      for (int j = 0; j < childrenOfRule.getLength(); j++) {
        switch (childrenOfRule.item(j).getNodeName()) {
          case "repositoryKey":
            repoKey = childrenOfRule.item(j).getTextContent();
            break;
          case "key":
            ruleKey = childrenOfRule.item(j).getTextContent();
            break;
          case "priority":
            severity = childrenOfRule.item(j).getTextContent();
            break;
          default:
            break;
        }
      }

      if (!(FORBIDDEN_REPO_KEYS.contains(repoKey) || repoKey == null || ruleKey == null)) {
        currentRule = devonfwJava.activateRule(repoKey, ruleKey);
        if (severity != null) {
          currentRule.overrideSeverity(severity);
        }
      }
    }

    devonfwJava.done();
  }

  private Document readQualityProfileXml() {

    try (InputStream inputStream = DevonfwJavaProfile.class.getResourceAsStream(DEVONFW_JAVA)) {
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbFactory.newDocumentBuilder();
      return builder.parse(inputStream);
    } catch (ParserConfigurationException pc) {
      logger.log(Level.WARNING, "There was a problem configuring the parser.");
      return null;
    } catch (IOException io) {
      logger.log(Level.WARNING, "There was a problem reading the file.");
      return null;
    } catch (SAXException sax) {
      logger.log(Level.WARNING, "There was a problem parsing the file.");
      return null;
    }
  }

  private List<String> getPlugins() {

    String command = "cmd /c dir";
    File pluginDirectory = null;
    List<String> pluginList = new ArrayList<>();

    if (this.testEnv) {
      pluginDirectory = new File("src/test/files/qualityprofile/extensions/plugins");
    } else {
      pluginDirectory = new File("extensions/plugins");
    }

    try {
      Process process = HOST_ENVIRONMENT.exec(command, null, pluginDirectory);
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line = "";
      String currentPlugin;
      while ((line = reader.readLine()) != null) {
        currentPlugin = trimPluginNames(line);
        if (currentPlugin != null) {
          pluginList.add(currentPlugin);
        }
      }
      reader.close();
      return pluginList;
    } catch (IOException io) {
      logger.log(Level.INFO, "Command could not be executed");
      return new ArrayList<>();
    }
  }

  private String trimPluginNames(String line) {

    String[] splitLine = line.split(" ");
    String currentPlugin = null;

    if (splitLine[splitLine.length - 1].endsWith(".jar")) {
      currentPlugin = splitLine[splitLine.length - 1];
      currentPlugin = currentPlugin.split("-[0-9]")[0];
      return currentPlugin;
    }

    return currentPlugin;
  }

  private void disableRepoKeys(List<String> pluginList) {

    if (!pluginList.contains(QUALINSIGHT)) {
      disableQualinsight();
    }

    if (!pluginList.contains(PMD)) {
      disablePMD();
    }

    if (!pluginList.contains(CHECKSTYLE)) {
      disableCheckstyle();
    }

    if (!pluginList.contains(FINDBUGS)) {
      disableFindbugs();
    }
  }

  private void disableQualinsight() {

    FORBIDDEN_REPO_KEYS.add("qualinsight-smells");
  }

  private void disablePMD() {

    FORBIDDEN_REPO_KEYS.add("pmd");
    FORBIDDEN_REPO_KEYS.add("pmd-unit-tests");
  }

  private void disableCheckstyle() {

    FORBIDDEN_REPO_KEYS.add("checkstyle");
  }

  private void disableFindbugs() {

    FORBIDDEN_REPO_KEYS.add("findbugs");
    FORBIDDEN_REPO_KEYS.add("findsecbugs");
    FORBIDDEN_REPO_KEYS.add("fb-contrib");
  }
}
