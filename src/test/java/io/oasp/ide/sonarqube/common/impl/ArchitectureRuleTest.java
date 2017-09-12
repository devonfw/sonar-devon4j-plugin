package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;

import io.oasp.ide.sonarqube.common.api.DevonConstants;
import io.oasp.module.basic.common.api.reflect.OaspPackage;
import io.oasp.module.test.common.base.ModuleTest;

/**
 * Test for {@link ArchitectureRule}.
 */
public class ArchitectureRuleTest extends ModuleTest {

  private ArchitectureRule createArchitectureRule() {

    return new ArchitectureRule();
  }

  /**
   * Test of {@link ArchitectureRule#verifyDependency(Class, Class)} for various {@link OaspPackage#getScope() scopes}.
   */
  @Test
  public void testScopes() {

    // given
    ArchitectureRule rule = createArchitectureRule();

    // then
    assertThat(rule.verifyDependency(DevonPlugin.class, ArchitectureRule.class)).isTrue();
    assertThat(rule.verifyDependency(DevonPlugin.class, DevonConstants.class)).isTrue();
    assertThat(rule.verifyDependency(DevonConstants.class, DevonPlugin.class)).isFalse();
  }

}
