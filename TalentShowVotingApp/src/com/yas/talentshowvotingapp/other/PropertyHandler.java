package com.yas.talentshowvotingapp.other;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyHandler {

	private static PropertyHandler instance = null;
	private InputStream input = null;
	private Properties props = null;

	final static Logger logger = Logger.getLogger("PropertyHandler");
	
	private PropertyHandler() {
		// Here you could read the file into props object

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			this.props.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public static synchronized PropertyHandler getInstance() {
		if (instance == null)
			instance = new PropertyHandler();
		return instance;
	}

	public String getValue(String propKey) {
		return this.props.getProperty(propKey);
	}
}