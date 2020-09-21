package com.devonfw.ide.sonarqube.common.impl;

import java.util.List;

import org.junit.Test;
import org.sonar.api.Plugin;
import org.sonar.api.SonarEdition;
import org.sonar.api.SonarQubeSide;
import org.sonar.api.internal.PluginContextImpl;
import org.sonar.api.internal.SonarRuntimeImpl;
import org.sonar.api.utils.Version;

import com.devonfw.module.test.common.base.ModuleTest;

/**
 * Test of {@link SonarDevon4jPlugin}
 */
public class SonarDevon4jPluginTest extends ModuleTest {

  /**
   * Test of {@link SonarDevon4jPlugin}
   */
  @Test
  public void test() {

    SonarDevon4jPlugin plugin = new SonarDevon4jPlugin();
    PluginContextImpl.Builder builder = new PluginContextImpl.Builder();
    builder.setSonarRuntime(
        SonarRuntimeImpl.forSonarQube(Version.create(5, 7), SonarQubeSide.SERVER, SonarEdition.SONARCLOUD));
    Plugin.Context context = builder.build();
    plugin.define(context);
    List<Class<?>> extensions = context.getExtensions();

    assertThat(extensions).contains(DevonSonarDefinition.class, DevonSonarRegistrar.class);
  }

}
