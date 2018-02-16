package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author ssabah
 *
 */
public class DevonArchitectureLayerClientDataaccessCheckTest {

  @Test

  public void test() {

    JavaCheckVerifier.verify("src/test/files/DevonArchitectureLayerClientDataaccessCheck.java",
        new DevonArchitectureLayerClientDataaccessCheck());
  }

}
