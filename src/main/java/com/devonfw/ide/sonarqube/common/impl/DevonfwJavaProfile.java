package com.devonfw.ide.sonarqube.common.impl;

import java.io.IOException;
import java.io.InputStream;
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
  private static final String DEVON4J_XML = "/com/devonfw/ide/sonarqube/common/rules/devon4j/devon4j.xml";

  private static final Logger logger = Logger.getGlobal();

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
    NewBuiltInActiveRule currentRule;
    String repoKey = null;
    String ruleKey = null;
    String severity = "";
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
      if (!(SonarDevon4jPlugin.getForbiddenRepoKeys().contains(repoKey) || repoKey == null || ruleKey == null)) {
        currentRule = devonfwJava.activateRule(repoKey, ruleKey);
        if (severity.isEmpty()) {
          currentRule.overrideSeverity(severity);
        }
      }
    }
    devonfwJava.done();
  }

  private Document readQualityProfileXml() {

    try (InputStream inputStream = DevonfwJavaProfile.class.getResourceAsStream(DEVON4J_XML)) {
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
}