package com.amazon.testing.service;

import static com.amazon.testing.util.Constants.BROWSER;
import static com.amazon.testing.util.Constants.DRIVER_C;
import static com.amazon.testing.util.Constants.DRIVER_LOCATION_C;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.amazon.testing.util.ProjectProperties;

public class PropertyService {
	ProjectProperties projectProperties= null;

	public PropertyService() throws Exception{
		projectProperties = new ProjectProperties();
	}

	public String getValue(String key) throws Exception{
		return projectProperties.getValue(key);
	}	
	public RemoteWebDriver getMyDriver() throws Exception {
		int browser = Integer.parseInt(getValue(BROWSER));
		RemoteWebDriver driver = null;

		switch(browser) {
		case 1:	System.setProperty(getValue(DRIVER_C),getValue(DRIVER_LOCATION_C));
		driver = new ChromeDriver();
		break;

		default:    System.err.println("something went wrong");
		}

		return driver;
	}
}
