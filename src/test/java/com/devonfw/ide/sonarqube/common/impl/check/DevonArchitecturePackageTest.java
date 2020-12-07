package com.devonfw.ide.sonarqube.common.impl.check;

import java.io.File;

import org.junit.Test;

import com.devonfw.ide.sonarqube.common.api.config.Architecture;
import com.devonfw.ide.sonarqube.common.api.config.Configuration;
import com.devonfw.ide.sonarqube.common.api.config.DevonArchitecturePackage;
import com.devonfw.ide.sonarqube.common.api.config.Packages;
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
  public void testCustomConfig() {

    ConfigurationMapper mapper = new ConfigurationMapper();
    File file = new File("src/test/files/DevonArchitecturePackage/architecture.json");
    Configuration config = mapper.fromJson(file);
    DevonArchitecturePackage pkg = new DevonArchitecturePackage(
        "com.devonfw.firstGroup.testApplication.persistence.testComponent.impl.detail",
        Architecture.getPackages(config.getArchitecture()));

    assertThat(pkg.isValid()).isTrue();
    assertThat(pkg.isValidLayer()).isTrue();
    assertThat(pkg.isValidScope()).isTrue();

    assertThat(pkg.isLayerBatch()).isFalse();
    assertThat(pkg.isLayerClient()).isFalse();
    assertThat(pkg.isLayerCommon()).isFalse();
    assertThat(pkg.isLayerDataAccess()).isTrue();
    assertThat(pkg.isLayerLogic()).isFalse();
    assertThat(pkg.isLayerService()).isFalse();

    assertThat(pkg.isScopeApi()).isFalse();
    assertThat(pkg.isScopeBase()).isFalse();
    assertThat(pkg.isScopeImpl()).isTrue();

    assertThat(pkg.getComponent()).isEqualTo("testComponent");
    assertThat(pkg.getLayer()).isEqualTo("dataaccess");
    assertThat(pkg.getRoot()).isEqualTo("com.devonfw.firstGroup");
    assertThat(pkg.getScope()).isEqualTo("impl");
  }

  @Test
  public void testDefault() {

    ConfigurationMapper mapper = new ConfigurationMapper();
    DevonArchitecturePackage pkg = new DevonArchitecturePackage(
        "com.devonfw.firstGroup.testApplication.testComponent.dataaccess.impl.detail", Packages.getDefault());

    assertThat(pkg.isValid()).isTrue();
    assertThat(pkg.isValidLayer()).isTrue();
    assertThat(pkg.isValidScope()).isTrue();

    assertThat(pkg.isLayerBatch()).isFalse();
    assertThat(pkg.isLayerClient()).isFalse();
    assertThat(pkg.isLayerCommon()).isFalse();
    assertThat(pkg.isLayerDataAccess()).isTrue();
    assertThat(pkg.isLayerLogic()).isFalse();
    assertThat(pkg.isLayerService()).isFalse();

    assertThat(pkg.isScopeApi()).isFalse();
    assertThat(pkg.isScopeBase()).isFalse();
    assertThat(pkg.isScopeImpl()).isTrue();

    assertThat(pkg.getComponent()).isEqualTo("testComponent");
    assertThat(pkg.getLayer()).isEqualTo("dataaccess");
    assertThat(pkg.getRoot()).isEqualTo("com.devonfw.firstGroup");
    assertThat(pkg.getScope()).isEqualTo("impl");
  }

  @Test
  public void testNonDevonPackage() {

    ConfigurationMapper mapper = new ConfigurationMapper();
    DevonArchitecturePackage pkg = new DevonArchitecturePackage("com.google.common.base", Packages.getDefault());

    assertThat(pkg.isValid()).isFalse();
    assertThat(pkg.isValidLayer()).isFalse();
    assertThat(pkg.isValidScope()).isFalse();

    assertThat(pkg.isLayerBatch()).isFalse();
    assertThat(pkg.isLayerClient()).isFalse();
    assertThat(pkg.isLayerCommon()).isFalse();
    assertThat(pkg.isLayerDataAccess()).isFalse();
    assertThat(pkg.isLayerLogic()).isFalse();
    assertThat(pkg.isLayerService()).isFalse();

    assertThat(pkg.isScopeApi()).isFalse();
    assertThat(pkg.isScopeBase()).isFalse();
    assertThat(pkg.isScopeImpl()).isFalse();

    assertThat(pkg.getPackage()).isEqualTo("com.google.common.base");
  }

}
