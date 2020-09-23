package com.devonfw.ide.sonarqube.common.impl.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.devonfw.ide.sonarqube.common.api.config.ArchitectureJsonReader;

public class ArchitectureJsonReaderTest {

  private ArchitectureJsonReader architectureJsonReader;

  @Test
  public void shouldReturnTrueWhenThereIsNoArchitectureJsonFile() {

    // given
    File file = new File("src/test/files/architecture/architect.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);

    // when
    boolean isDevon4jProject = this.architectureJsonReader.isDevon4jProject();

    // then
    assertTrue(isDevon4jProject);
  }

  @Test
  public void shouldReturnTrueWhenThereIsNoArchitectureProperty() {

    // given
    File file = new File("src/test/files/architecture/architectureNoArchitectureProperty.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);

    // when
    boolean isDevon4jProject = this.architectureJsonReader.isDevon4jProject();

    // then
    assertTrue(isDevon4jProject);
  }

  @Test
  public void shouldReturnTrueWhenItIsADevonProject() {

    // given
    File file = new File("src/test/files/architecture/architectureDevonProject.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);

    // when
    boolean isDevon4jProject = this.architectureJsonReader.isDevon4jProject();

    // then
    assertTrue(isDevon4jProject);
  }

  @Test
  public void shouldReturnFalseWhenItIsNonDevonProject() {

    // given
    File file = new File("src/test/files/architecture/architectureNonDevonProject.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);

    // when
    boolean isDevon4jProject = this.architectureJsonReader.isDevon4jProject();

    // then
    assertFalse(isDevon4jProject);
  }

  @Test
  public void shouldReturnNullAsPatternWhenThereWhenNoPackagesProperty() {

    // given
    File file = new File("src/test/files/architecture/architectureNoPackagesProperty.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);

    // when
    String pattern = this.architectureJsonReader.getPackageNamingPattern();

    // then
    assertNull(pattern);
  }

  @Test
  public void shouldReturnNullWhenThereIsNoPatternProperty() {

    // given
    File file = new File("src/test/files/architecture/architectureNoPatternProperty.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);

    // when
    String pattern = this.architectureJsonReader.getPackageNamingPattern();

    // then
    assertNull(pattern);
  }

  @Test
  public void shouldReturnANamingPattern() {

    // given
    File file = new File("src/test/files/architecture/architectureNonDevonProject.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);
    String expected = "([a-zA-Z0-9_]+\\.)+(persistence|core|service|gui+)\\.(api|base|impl)(\\.[a-zA-Z0-9_]+)*";

    // when
    String pattern = this.architectureJsonReader.getPackageNamingPattern();

    // then
    assertEquals(expected, pattern);
  }

  @Test
  public void shouldReturnNullAsMappingsWhenThereIsNoPackagesProperty() {

    // given
    File file = new File("src/test/files/architecture/architectureNoPackagesProperty.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);

    // when
    Map<String, String> nameMappings = this.architectureJsonReader.getPackageNameMappings();

    // then
    assertNull(nameMappings);
  }

  @Test
  public void shouldReturnNullWhenThereIsNoMappingsProperty() {

    // given
    File file = new File("src/test/files/architecture/architectureNoMappingsProperty.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);

    // when
    Map<String, String> nameMappings = this.architectureJsonReader.getPackageNameMappings();

    // then
    assertNull(nameMappings);
  }

  @Test
  public void shouldReturnANameMappings() {

    // given
    File file = new File("src/test/files/architecture/architectureNonDevonProject.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);
    Map<String, String> expected = new HashMap<>();
    expected.put("persistence", "dataaccess");
    expected.put("core", "logic");
    expected.put("gui", "client");

    // when
    Map<String, String> packageNameMappings = this.architectureJsonReader.getPackageNameMappings();

    // then
    assertEquals(expected, packageNameMappings);
  }

  @Test
  public void shouldReturnANameMappingForGivenLayer() {

    // given
    File file = new File("src/test/files/architecture/architectureNonDevonProject.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);
    String layer = "persistence";
    String expected = "dataaccess";

    // when
    String nameMapping = this.architectureJsonReader.getNameMappingForGivenLayer(layer);

    // then
    assertEquals(expected, nameMapping);
  }

  @Test
  public void shouldReturnNullAsANameMappingForGivenLayerWhenNoMappingsProperty() {

    // given
    File file = new File("src/test/files/architecture/architectureNoMappingsProperty.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);
    String layer = "persistence";

    // when
    String nameMapping = this.architectureJsonReader.getNameMappingForGivenLayer(layer);

    // then
    assertNull(nameMapping);
  }

  @Test
  public void shouldReturnNullWhenThereIsNoMappingForGivenLayer() {

    // given
    File file = new File("src/test/files/architecture/architectureNonDevonProject.json");
    this.architectureJsonReader = new ArchitectureJsonReader(file);
    String layer = "layer";

    // when
    String nameMapping = this.architectureJsonReader.getNameMappingForGivenLayer(layer);

    // then
    assertNull(nameMapping);
  }

}
