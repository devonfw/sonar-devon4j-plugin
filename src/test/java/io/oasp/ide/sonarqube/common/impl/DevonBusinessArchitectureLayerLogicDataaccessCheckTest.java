package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author ssabah
 *
 */
public class DevonBusinessArchitectureLayerLogicDataaccessCheckTest {

  @Test
  public void test() {

    DevonBusinessArchitectureLayerLogicDataaccessCheck check = new DevonBusinessArchitectureLayerLogicDataaccessCheck();
    check.configJson = "{\"businessArchitecture\":" + //
        "{\"components\":[" + //
        "{\"name\":\"compA\",\"dependencies\":[\"compB\"]}," + //
        "{\"name\":\"compB\",\"dependencies\":[]}" + //
        "]}}";
    JavaCheckVerifier.verify("src/test/files/DevonBusinessArchitectureLayerLogicDataaccessCheck.java", check);
  }

}
