package com.amazon.testing;

import static com.amazon.testing.util.Constants.*;
import static com.amazon.testing.util.DataConstants.*;


import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import com.amazon.testing.service.PropertyService;
import com.amazon.testing.util.Util;

public class LaunchApp {

	public static PropertyService propertyService = null;
	private Logger logger = LogManager.getLogger(LaunchApp.class.getClass());
	public static Util util = null;
	public static ExcelRead dataExcel = null;
	@BeforeSuite
	public void launch() throws Exception {
		
		try {
			propertyService = new PropertyService();
			RemoteWebDriver driver = propertyService.getMyDriver();
			logger.info("App Lauching ...");
			driver.get(propertyService.getValue(URL));
			driver.manage().window().maximize();
			util = new Util(driver);
			ExcelRead dataExcel = new ExcelRead();
			dataExcel.prepareData();
			logger.info("App Launched and maximized...");
			util.waitAndSendKey(propertyService.getValue(SEARCH),dataExcel.getValue(SEARCH_DATA));
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
