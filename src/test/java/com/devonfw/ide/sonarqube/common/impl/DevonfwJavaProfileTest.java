package com.devonfw.ide.sonarqube.common.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition.BuiltInActiveRule;
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

    // Create new test profile
    DevonfwJavaProfile profileDef = new DevonfwJavaProfile();
    BuiltInQualityProfilesDefinition.Context context = new BuiltInQualityProfilesDefinition.Context();
    profileDef.define(context);
    BuiltInQualityProfilesDefinition.BuiltInQualityProfile profile = context.profile(Java.KEY, "devonfw Java");

    // Get all rule keys
    Set<String> ruleKeys = new HashSet<>();
    for (BuiltInActiveRule rule : profile.rules()) {
      ruleKeys.add(rule.ruleKey());
    }

    // Assertions
    assertThat(profile.language()).isEqualTo(Java.KEY);
    assertThat(profile.name()).isEqualTo("devonfw Java");
  }

}
