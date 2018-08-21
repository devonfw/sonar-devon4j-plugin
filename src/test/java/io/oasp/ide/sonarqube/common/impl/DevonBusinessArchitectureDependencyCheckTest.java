package io.oasp.ide.sonarqube.common.impl;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class DevonBusinessArchitectureDependencyCheckTest {

  @Test
  public void test() {

    DevonBusinessArchitectureDependencyCheck check = new DevonBusinessArchitectureDependencyCheck();
    check.configJson = "{\"businessArchitecture\":" + //
        "{\"components\":[" + //
        "{\"name\":\"compA\",\"dependencies\":[\"compB\"]}," + //
        "{\"name\":\"compB\",\"dependencies\":[]}" + //
        "]}}";
    JavaCheckVerifier.verify("src/test/files/DevonBusinessArchitectureDependencyCheck.java", check);
  }

  @Test
  public void test2() {

    DevonBusinessArchitectureDependencyCheck check = new DevonBusinessArchitectureDependencyCheck();
    check.configJson = "{\"businessArchitecture\":" + //
        "{\"components\":[" + //
        "{\"name\":\"compA\",\"dependencies\":[\"compB\"]}," + //
        "{\"name\":\"compB\",\"dependencies\":[]}" + //
        "]}}";
    JavaCheckVerifier.verify("src/test/files/DevonBusinessArchitectureDependencyCheck2.java", check);
  }

}
