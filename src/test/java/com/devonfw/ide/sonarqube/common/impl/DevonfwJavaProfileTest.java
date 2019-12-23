package com.devonfw.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.plugins.java.Java;

import com.devonfw.module.test.common.base.ModuleTest;

/**
 * @author lniazman
 *
 */
public class DevonfwJavaProfileTest extends ModuleTest {

  /**
   * Test of {@link DevonfwJavaProfile}
   */
  @Test
  public void test() {

    DevonfwJavaProfile profileDef = new DevonfwJavaProfile();
    BuiltInQualityProfilesDefinition.Context context = new BuiltInQualityProfilesDefinition.Context();
    profileDef.define(context);
    BuiltInQualityProfilesDefinition.BuiltInQualityProfile profile = context.profile("java", "devonfw Java");
    assertThat(profile.language()).isEqualTo(Java.KEY);
  }

}
