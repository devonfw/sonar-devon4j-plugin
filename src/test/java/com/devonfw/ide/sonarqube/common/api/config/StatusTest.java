package com.devonfw.ide.sonarqube.common.api.config;

import org.junit.Test;

import com.devonfw.module.test.common.base.ModuleTest;

/**
 * Test of {@link Status}
 */
public class StatusTest extends ModuleTest {

  /**
   * Test of {@link Status}
   */
  @Test
  public void test() {

    Status status = new Status();
    assertThat(status.getErrors()).isNotNull();

    String error = "Error message";
    status.addError(error);

    status.setErrorsReported();
    assertThat(status.isErrorsReported()).isTrue();
  }

}
