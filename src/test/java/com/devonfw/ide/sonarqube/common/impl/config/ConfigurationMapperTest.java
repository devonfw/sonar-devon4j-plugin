package com.devonfw.ide.sonarqube.common.impl.config;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;

import com.devonfw.ide.sonarqube.common.api.config.Configuration;
import com.devonfw.ide.sonarqube.common.api.config.Packages;
import com.devonfw.module.test.common.base.ModuleTest;

/**
 * Test of {@link ConfigurationMapper}.
 */
public class ConfigurationMapperTest extends ModuleTest {

  private static final String JSON_EXAMPLE = "{\"architecture\":" + //
      "{\"components\":[" + //
      "{\"name\":\"component1\",\"dependencies\":[\"component2\"]}," + //
      "{\"name\":\"component2\",\"dependencies\":[\"component3\"],\"nonTransitiveDependencies\":[\"io.oasp.module.jpa\"]},"
      + //
      "{\"name\":\"component3\",\"dependencies\":[]}" + //
      "]}}";

  // /**
  // * Test of {@link ConfigurationMapper#toJson(Configuration)}.
  // */
  // @Test
  // public void testToJson() {
  //
  // // given
  // Configuration config = new Configuration();
  // List<Component> components = config.getArchitecture().getComponents();
  // Component component1 = new Component("component1");
  // Component component2 = new Component("component2");
  // Component component3 = new Component("component3");
  // component1.getDependencies().add(component2.getName());
  // component2.getDependencies().add(component3.getName());
  // component2.setNonTransitiveDependencies(new HashSet<>());
  // component2.getNonTransitiveDependencies().add("io.oasp.module.jpa");
  // components.add(component1);
  // components.add(component2);
  // components.add(component3);
  // ConfigurationMapper mapper = new ConfigurationMapper();
  //
  // // when
  // String json = mapper.toJson(config);
  //
  // // then
  // assertThat(json).isEqualTo(JSON_EXAMPLE);
  // }
  //
  // /**
  // * Test of {@link ConfigurationMapper#fromJson(String)}.
  // */
  // @Test
  // public void testFromJson() {
  //
  // // given
  // String json = JSON_EXAMPLE;
  // ConfigurationMapper mapper = new ConfigurationMapper();
  //
  // // when
  // Configuration config = mapper.fromJson(json);
  //
  // // then
  // assertThat(config).isNotNull();
  // Architecture businessArchitecture = config.getArchitecture();
  // assertThat(businessArchitecture).isNotNull();
  // List<Component> components = businessArchitecture.getComponents();
  // assertThat(components).isNotNull().hasSize(3);
  // Component component1 = components.get(0);
  // assertThat(component1.getName()).isEqualTo("component1");
  // assertThat(component1.getDependencies()).containsExactlyInAnyOrder("component2");
  // assertThat(component1.allDependencies()).containsExactlyInAnyOrder("general", "component2", "component3");
  // Component component2 = components.get(1);
  // assertThat(component2.getName()).isEqualTo("component2");
  // assertThat(component2.getDependencies()).containsExactlyInAnyOrder("component3");
  // assertThat(component2.allDependencies()).containsExactlyInAnyOrder("general", "component3", "io.oasp.module.jpa");
  // Component component3 = components.get(2);
  // assertThat(component3.getName()).isEqualTo("component3");
  // assertThat(component3.getDependencies()).isEmpty();
  // assertThat(component3.allDependencies()).containsExactlyInAnyOrder("general");
  // }
  //
  // /**
  // * Test of {@link ConfigurationMapper#fromJson(String)}.
  // */
  // @Test
  // public void testFromJsonWithGeneral() {
  //
  // // given
  // String json = "{\"architecture\":" + //
  // "{\"components\":[" + //
  // "{\"name\":\"general\",\"dependencies\":[\"io.oasp.module.jpa\",\"io.oasp.module.beanmapping\",\"io.oasp.module.basic\"]},"
  // + //
  // "{\"name\":\"component1\",\"dependencies\":[\"component2\"]}," + //
  // "{\"name\":\"component2\",\"dependencies\":[\"component3\"],\"nonTransitiveDependencies\":[\"com.devon.module.jpa\"]},"
  // + //
  // "{\"name\":\"component3\",\"dependencies\":[]}" + //
  // "]}}";
  // ConfigurationMapper mapper = new ConfigurationMapper();
  //
  // // when
  // Configuration config = mapper.fromJson(json);
  //
  // // then
  // assertThat(config).isNotNull();
  // Architecture businessArchitecture = config.getArchitecture();
  // assertThat(businessArchitecture).isNotNull();
  // List<Component> components = businessArchitecture.getComponents();
  // assertThat(components).isNotNull().hasSize(4);
  // Component component1 = components.get(0);
  // assertThat(component1.getName()).isEqualTo("general");
  // assertThat(component1.getDependencies()).containsExactlyInAnyOrder("io.oasp.module.jpa",
  // "io.oasp.module.beanmapping", "io.oasp.module.basic");
  // assertThat(component1.allDependencies()).containsExactlyInAnyOrder("io.oasp.module.jpa",
  // "io.oasp.module.beanmapping", "io.oasp.module.basic");
  // Component component2 = components.get(1);
  // assertThat(component2.getName()).isEqualTo("component1");
  // assertThat(component2.getDependencies()).containsExactlyInAnyOrder("component2");
  // assertThat(component2.allDependencies()).containsExactlyInAnyOrder("general", "component2", "component3",
  // "io.oasp.module.jpa", "io.oasp.module.beanmapping", "io.oasp.module.basic");
  // Component component3 = components.get(2);
  // assertThat(component3.getName()).isEqualTo("component2");
  // assertThat(component3.getDependencies()).containsExactlyInAnyOrder("component3");
  // assertThat(component3.allDependencies()).containsExactlyInAnyOrder("general", "component3", "com.devon.module.jpa",
  // "io.oasp.module.jpa", "io.oasp.module.beanmapping", "io.oasp.module.basic");
  // Component component4 = components.get(3);
  // assertThat(component4.getName()).isEqualTo("component3");
  // assertThat(component4.getDependencies()).isEmpty();
  // assertThat(component4.allDependencies()).containsExactlyInAnyOrder("general", "io.oasp.module.jpa",
  // "io.oasp.module.beanmapping", "io.oasp.module.basic");
  // }
  //
  // /**
  // * Test of {@link ConfigurationMapper#fromJson(String)}.
  // */
  // @Test
  // public void testFromJsonIllegalCyclicDependency() {
  //
  // // given
  // String json = "{\"architecture\":" + //
  // "{\"components\":[" + //
  // "{\"name\":\"component1\",\"dependencies\":[\"component2\"]}," + //
  // "{\"name\":\"component2\",\"dependencies\":[\"component3\"]}," + //
  // "{\"name\":\"component3\",\"dependencies\":[\"component1\"]}" + //
  // "]}}";
  // ConfigurationMapper mapper = new ConfigurationMapper();
  //
  // // when
  // Configuration config = mapper.fromJson(json);
  //
  // // then
  // assertThat(config).isNotNull();
  // Status status = config.status();
  // assertThat(status).isNotNull();
  // assertThat(status.getErrors())
  // .containsExactly("Cyclic dependency detected: components->component1->component2->component3->component1");
  // }
  //
  // /**
  // * Test of {@link ConfigurationMapper#fromJson(String)}.
  // */
  // @Test
  // public void testFromJsonIllegalDuplicateComponent() {
  //
  // // given
  // String json = "{\"architecture\":" + //
  // "{\"components\":[" + //
  // "{\"name\":\"component1\",\"dependencies\":[\"general\"]}," + //
  // "{\"name\":\"component1\",\"dependencies\":[\"general\"]}" + //
  // "]}}";
  // ConfigurationMapper mapper = new ConfigurationMapper();
  //
  // // when
  // Configuration config = mapper.fromJson(json);
  //
  // // then
  // assertThat(config).isNotNull();
  // Status status = config.status();
  // assertThat(status).isNotNull();
  // assertThat(status.getErrors()).containsExactly("Duplicate architecture component 'component1'.");
  // }
  //
  // /**
  // * Test of {@link ConfigurationMapper#fromJson(String)}.
  // */
  // @Test
  // public void testFromJsonIllegalUndefinedDependency() {
  //
  // // given
  // String json = "{\"architecture\":" + //
  // "{\"components\":[" + //
  // "{\"name\":\"component1\",\"dependencies\":[\"general\",\"com.devonfw.modules.jpa\",\"component2\"]}" + //
  // "]}}";
  // ConfigurationMapper mapper = new ConfigurationMapper();
  //
  // // when
  // Configuration config = mapper.fromJson(json);
  //
  // // then
  // assertThat(config).isNotNull();
  // Status status = config.status();
  // assertThat(status).isNotNull();
  // assertThat(status.getErrors())
  // .containsExactly("Component 'component1' has dependency 'component2' but no such component is defined.");
  // }

  @Test
  public void testFromJsonFileWhenPackagesIsPresent() {

    Logger logger = Logger.getLogger("logger");

    // given
    ConfigurationMapper mapper = new ConfigurationMapper();
    File file = new File("src/test/architecture.json");
    String expectedPattern = "([a-zA-Z0-9_]+\\.)+(persistence|core|service|gui)\\.([a-zA-Z0-9_]+)\\.(api|base|impl)(\\.[a-zA-Z0-9_]+)*";
    List<String> expectedDetails = Arrays.asList("root", "layer", "component", "scope", "detail");
    Map<String, String> expectedMappings = new HashMap<>();
    expectedMappings.put("persistence", "dataaccess");
    expectedMappings.put("core", "logic");
    expectedMappings.put("gui", "client");

    // when
    Configuration config = mapper.fromJson(file);

    // then
    Packages packages = config.getArchitecture().getPackages();
    assertThat(packages).isNotNull();
    assertThat(packages.getPattern()).isEqualTo(expectedPattern);
    assertThat(packages.getGroups()).isEqualTo(expectedDetails);
    assertThat(packages.getMappings()).hasSize(3).containsEntry("persistence", "dataaccess")
        .containsEntry("core", "logic").containsEntry("gui", "client");
  }

}
