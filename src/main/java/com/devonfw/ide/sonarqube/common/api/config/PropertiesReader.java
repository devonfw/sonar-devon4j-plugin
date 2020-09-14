package com.devonfw.ide.sonarqube.common.api.config;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;

public class PropertiesReader {

    public boolean isDevon4jProject() throws IOException {

        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model;
        try {
            model = reader.read(new FileReader("pom.xml"));
            return model.getProperties().containsKey("devon4j.version");

        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
        return false;
    }

}
