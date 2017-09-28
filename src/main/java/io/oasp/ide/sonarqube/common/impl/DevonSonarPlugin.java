package io.oasp.ide.sonarqube.common.impl;

import org.sonar.api.Plugin;

/**
 * TODO
 */
public class DevonSonarPlugin implements Plugin {

	@Override
	public void define(Context context) {

		context.addExtension(DevonSonarDefinition.class);

		context.addExtension(DevonSonarRegistrar.class);

	}

}
