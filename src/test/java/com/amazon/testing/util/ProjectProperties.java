package com.amazon.testing.util;

import static com.amazon.testing.util.Constants.*;

import java.io.FileReader;
import java.util.Properties;
public class ProjectProperties {
	private Properties projectProperty = null;
	
	public ProjectProperties() throws Exception{
		FileReader reader = new FileReader(PROPERTY_LOCATION);
		projectProperty = new Properties();
		projectProperty.load(reader);
	}
	public String getValue(String key) {
		return projectProperty.getProperty(key);
	}
}
