package com.yas.talentshowvotingapp.controller;

import com.yas.talentshowvotingapp.view.ConfigurationView;

public class ConfigurationController {

	private ConfigurationView configurationView;

	public ConfigurationController(ConfigurationView configurationView) {
		super();
		this.configurationView = configurationView;
	}

	public ConfigurationView getConfigurationView() {
		return configurationView;
	}

	public void setConfigurationView(ConfigurationView configurationView) {
		this.configurationView = configurationView;
	}

}
