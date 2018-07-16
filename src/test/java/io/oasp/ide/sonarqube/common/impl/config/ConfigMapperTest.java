package io.oasp.ide.sonarqube.common.impl.config;

import java.util.List;

import org.junit.Test;

import io.oasp.ide.sonarqube.common.api.config.BusinessArchitecture;
import io.oasp.ide.sonarqube.common.api.config.Component;
import io.oasp.ide.sonarqube.common.api.config.Config;
import io.oasp.module.test.common.base.ModuleTest;

/**
 * @author ssabah
 *
 */
public class ConfigMapperTest extends ModuleTest {

  /**
   *
   */
  private static final String JSON_EXAMPLE = "{\"businessArchitecture\":" + //
      "{\"components\":[" + //
      "{\"name\":\"component1\",\"dependencies\":[\"component2\"]}," + //
      "{\"name\":\"component2\",\"dependencies\":[\"component3\"]}," + //
      "{\"name\":\"component3\",\"dependencies\":[]}" + //
      "]}}";

  @Test
  public void testToJson() {

    // given
    Config config = new Config();
    List<Component> components = config.getBusinessArchitecture().getComponents();
    Component component1 = new Component("component1");
    Component component2 = new Component("component2");
    Component component3 = new Component("component3");
    component1.getDependencies().add(component2.getName());
    component2.getDependencies().add(component3.getName());
    components.add(component1);
    components.add(component2);
    components.add(component3);
    ConfigMapper mapper = new ConfigMapper();

    // when
    String json = mapper.toJson(config);

    // then
    assertThat(json).isEqualTo(JSON_EXAMPLE);
  }

  @Test
  public void testFromJson() {

    // given
    String json = JSON_EXAMPLE;
    ConfigMapper mapper = new ConfigMapper();

    // when
    Config config = mapper.fromJson(json);

    // then
    assertThat(config).isNotNull();
    BusinessArchitecture businessArchitecture = config.getBusinessArchitecture();
    assertThat(businessArchitecture).isNotNull();
    List<Component> components = businessArchitecture.getComponents();
    assertThat(components).isNotNull().hasSize(3);
    Component component1 = components.get(0);
    assertThat(component1.getName()).isEqualTo("component1");
    assertThat(component1.getDependencies()).containsExactly("component2");
    Component component2 = components.get(1);
    assertThat(component2.getName()).isEqualTo("component2");
    assertThat(component2.getDependencies()).containsExactly("component3");
    Component component3 = components.get(2);
    assertThat(component3.getName()).isEqualTo("component3");
    assertThat(component3.getDependencies()).isEmpty();
  }

}
