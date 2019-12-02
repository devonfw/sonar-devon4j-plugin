package com.devonfw.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.Param;
import org.sonar.api.server.rule.RulesDefinition.Repository;
import org.sonar.api.server.rule.RulesDefinition.Rule;

import com.devonfw.module.test.common.base.ModuleTest;

/**
 * Test of {@link DevonSonarDefinition}.
 */
public class DevonSonarDefinitionTest extends ModuleTest {

  /**
   * Test of {@link DevonSonarDefinition}.
   */
  @Test
  public void test() {

    DevonSonarDefinition rulesDefinition = new DevonSonarDefinition();
    RulesDefinition.Context context = new RulesDefinition.Context();
    rulesDefinition.define(context);
    RulesDefinition.Repository repository = context.repository(DevonSonarDefinition.REPOSITORY_KEY);

    assertThat(repository.name()).isEqualTo("devonfw Java Rules");
    assertThat(repository.language()).isEqualTo("java");
    assertThat(repository.rules().size()).isGreaterThanOrEqualTo(28);

    assertAllRuleParametersHaveDescription(repository);
  }

  private void assertAllRuleParametersHaveDescription(Repository repository) {

    for (Rule rule : repository.rules()) {
      String ruleKey = rule.key();
      assertThat(ruleKey).isNotEmpty();
      assertThat(rule).isNotNull();
      assertThat(repository.rule(ruleKey).htmlDescription()).isNotNull();
      for (Param param : rule.params()) {
        assertThat(param.description()).as("description for " + param.key()).isNotEmpty();
      }
    }
  }

}
