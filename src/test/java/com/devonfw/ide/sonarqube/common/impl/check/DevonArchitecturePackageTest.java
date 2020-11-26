package com.devonfw.ide.sonarqube.common.impl.check;

import java.io.File;
import java.util.logging.Logger;

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

  @Test
  public void test() {

    Logger logger = Logger.getLogger("logger");

    // given
    ConfigurationMapper mapper = new ConfigurationMapper();
    File file = new File("src/test/architecture.json");
    Configuration config = mapper.fromJson(file);
    DevonArchitecturePackage pkg = new DevonArchitecturePackage("root",
        Architecture.getPackages(config.getArchitecture()));
  }

}
