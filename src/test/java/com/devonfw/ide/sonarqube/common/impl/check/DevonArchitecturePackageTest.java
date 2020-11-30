package com.devonfw.ide.sonarqube.common.impl.check;

import java.io.File;

import org.junit.Test;

import com.devonfw.ide.sonarqube.common.api.config.Architecture;
import com.devonfw.ide.sonarqube.common.api.config.Configuration;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.impl.config.ConfigurationMapper;
import com.devonfw.module.test.common.base.ModuleTest;

/**
 * @author lniazman
 *
 */
public class DevonArchitecturePackageTest extends ModuleTest {

  /**
   * Tests construction of {@link DevonArchitecturePackage} and the use of its methods
   */
  @Test
  public void test() {

    ConfigurationMapper mapper = new ConfigurationMapper();
    File file = new File("src/test/architecture.json");
    Configuration config = mapper.fromJson(file);
    DevonArchitecturePackage pkg = new DevonArchitecturePackage(
        "com.devonfw.firstGroup.test.persistence.testComponent.impl.TestClass",
        Architecture.getPackages(config.getArchitecture()));

    assertThat(pkg.getLayer()).isEqualTo("dataaccess");
    assertThat(pkg.getScope()).isEqualTo("impl");
    assertThat(pkg.getApplication()).isEqualTo(".TestClass");
  }

}
