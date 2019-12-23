package com.devonfw.ide.sonarqube.common.impl;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.AnnotationUtils;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * This class creates a quality profile containing the rules of this plugin.
 */
@SonarLintSide
public class DevonfwJavaProfile implements BuiltInQualityProfilesDefinition {

  @Override
  public void define(Context context) {

    NewBuiltInQualityProfile devonfwJava = context.createBuiltInQualityProfile("devonfw Java", "java");
    Rule ruleAnnotation;
    NodeList ruleList = readQualityProfileXml();
    NodeList childrenOfRule;
    String repoKey = null;
    String ruleKey = null;

    for (int i = 0; i < ruleList.getLength(); i++) {

      childrenOfRule = ruleList.item(i).getChildNodes();

      for (int j = 0; j < childrenOfRule.getLength(); j++) {

        if (childrenOfRule.item(j).getNodeName().equals("repositoryKey")) {
          repoKey = childrenOfRule.item(j).getTextContent();
        } else if (childrenOfRule.item(j).getNodeName().equals("key")) {
          ruleKey = childrenOfRule.item(j).getTextContent();
        }

      }

      devonfwJava.activateRule(repoKey, ruleKey);
    }

    for (Class<? extends JavaCheck> check : DevonSonarRegistrar.checkClasses()) {

      ruleAnnotation = AnnotationUtils.getAnnotation(check, Rule.class);
      devonfwJava.activateRule(DevonSonarDefinition.REPOSITORY_KEY, ruleAnnotation.key());
    }

    devonfwJava.setDefault(true);
    devonfwJava.done();
  }

  private NodeList readQualityProfileXml() {

    Logger logger = Logger.getLogger("logger");
    File qualityProfileXml = new File(
        "src/main/resources/com/devonfw/ide/sonarqube/common/rules/devon4j/devonfwJava.xml");

    try {

      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbFactory.newDocumentBuilder();
      Document document = builder.parse(qualityProfileXml);
      return document.getElementsByTagName("rule");

    } catch (ParserConfigurationException pc) {
      pc.printStackTrace();
      logger.log(Level.WARNING, "There was a problem configuring the parser.");
      return null;
    } catch (IOException io) {
      io.printStackTrace();
      return null;
    } catch (SAXException sax) {
      sax.printStackTrace();
      return null;
    }

  }

}
