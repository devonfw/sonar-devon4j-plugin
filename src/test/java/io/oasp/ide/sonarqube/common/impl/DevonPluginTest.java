package io.oasp.ide.sonarqube.common.impl;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.sonar.api.Plugin.Context;

import io.oasp.module.test.common.base.ModuleTest;

/**
 * Test of {@link DevonPlugin}.
 */
public class DevonPluginTest extends ModuleTest {

  /**
   * Test von {@link DevonPlugin#define(Context)}.
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Test
  public void testDevonPlugin() {

    // given
    DevonPlugin plugin = new DevonPlugin();
    Context context = Mockito.mock(Context.class);
    ArgumentCaptor<Collection> captor = ArgumentCaptor.forClass(Collection.class);

    // when
    plugin.define(context);

    // then
    Mockito.verify(context).addExtensions(captor.capture());
    Collection extensions = captor.getValue();
    assertThat(extensions).isNotNull().hasSize(1).isInstanceOf(List.class);
    assertThat(((List) extensions).get(0)).isInstanceOf(ArchitectureRule.class);
  }

}
