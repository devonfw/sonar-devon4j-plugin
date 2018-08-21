package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author ssabah
 *
 */
public class DevonBusinessArchitectureLayerServiceLogicCheckTest {

  @Test
  public void test() {

    DevonBusinessArchitectureLayerServiceLogicCheck check = new DevonBusinessArchitectureLayerServiceLogicCheck();
    check.configJson = "{\"businessArchitecture\":" + //
        "{\"components\":[" + //
        "{\"name\":\"compA\",\"dependencies\":[\"compB\"]}," + //
        "{\"name\":\"compB\",\"dependencies\":[]}" + //
        "]}}";
    JavaCheckVerifier.verify("src/test/files/DevonBusinessArchitectureLayerServiceLogicCheck.java", check);
  }
}
