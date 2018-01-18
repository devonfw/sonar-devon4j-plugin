package io.oasp.ide.sonarqube.common.impl;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.Param;
import org.sonar.api.server.rule.RulesDefinition.Repository;
import org.sonar.api.server.rule.RulesDefinition.Rule;

public class DevonSonarDefinitionTest {

  @Test
  public void test() {

    DevonSonarDefinition rulesDefinition = new DevonSonarDefinition();
    RulesDefinition.Context context = new RulesDefinition.Context();
    rulesDefinition.define(context);
    RulesDefinition.Repository repository = context.repository(DevonSonarDefinition.REPOSITORY_KEY);

    assertThat(repository.name()).isEqualTo("Devon Java Rules");
    assertThat(repository.language()).isEqualTo("java");
    assertThat(repository.rules()).hasSize(4);

    // adding the checks number

    assertAllRuleParametersHaveDescription(repository);
  }

  private void assertAllRuleParametersHaveDescription(Repository repository) {

    for (Rule rule : repository.rules()) {
      for (Param param : rule.params()) {
        assertThat(param.description()).as("description for " + param.key()).isNotEmpty();
      }
    }
  }

}
