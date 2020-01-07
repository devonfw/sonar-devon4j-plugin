package com.devonfw.ide.sonarqube.common.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.check.Rule;
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

  @Override
  public void define(Context context) {

    NewBuiltInQualityProfile devonfwJava = context.createBuiltInQualityProfile("devonfw Java", "java");
    Rule ruleAnnotation;
    NodeList ruleList = readQualityProfileXml();
    NodeList childrenOfRule;
    String repoKey = null;
    String ruleKey = null;
    String severity = null;

    logger.log(Level.INFO, "Number of rules: " + ruleList.getLength());

    /*
     * Activates external rules
     */
    for (int i = 0; i < ruleList.getLength(); i++) {

      childrenOfRule = ruleList.item(i).getChildNodes();

      for (int j = 0; j < childrenOfRule.getLength(); j++) {

        if (childrenOfRule.item(j).getNodeName().equals("repositoryKey")) {
          repoKey = childrenOfRule.item(j).getTextContent();
        } else {
          repoKey = null;
        }

        if (childrenOfRule.item(j).getNodeName().equals("key")) {
          ruleKey = childrenOfRule.item(j).getTextContent();
        } else {
          ruleKey = null;
        }

        if (childrenOfRule.item(j).getNodeName().equals("priority")) {
          severity = childrenOfRule.item(j).getTextContent();
        } else {
          severity = null;
        }

      }

      if (repoKey != null && ruleKey != null && severity != null) {
        devonfwJava.activateRule(repoKey, ruleKey);
      }

    }

    /*
     * Activates devon4j rules
     */
    // for (Class<? extends JavaCheck> check : DevonSonarRegistrar.checkClasses()) {
    // ruleAnnotation = AnnotationUtils.getAnnotation(check, Rule.class);
    // devonfwJava.activateRule(DevonSonarDefinition.REPOSITORY_KEY, ruleAnnotation.key());
    // }

    devonfwJava.setDefault(true);
    devonfwJava.done();

  }

  private NodeList readQualityProfileXml() {

    InputStream inputStream = DevonfwJavaProfile.class.getResourceAsStream(DEVONFW_JAVA);

    try {
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbFactory.newDocumentBuilder();
      Document document = builder.parse(inputStream);
      return document.getElementsByTagName("rule");
    } catch (ParserConfigurationException pc) {
      logger.log(Level.WARNING, "There was a problem configuring the parser.");
      return null;
    } catch (IOException io) {
      io.printStackTrace();
      logger.log(Level.WARNING, "There was a problem reading the file.");
      return null;
    } catch (SAXException sax) {
      logger.log(Level.WARNING, "There was a problem parsing the file.");
      return null;
    }

  }

}