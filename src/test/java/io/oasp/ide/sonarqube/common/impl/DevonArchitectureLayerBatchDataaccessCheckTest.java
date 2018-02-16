package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author ssabah
 *
 */
public class DevonArchitectureLayerBatchDataaccessCheckTest {

  @Test

  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerBatchDataaccessCheck.java",
        new DevonArchitectureLayerBatchDataaccessCheck());

  }

}
