package com.atmecs.phptravels.constants;

import com.atmecs.phptrtavels.testsuit.BaseTest;

public class Constants extends BaseTest {

	public static final String TestDATA_FILE = System.getProperty("user.dir")
			+ "/src/test/resources/TestData/TestData.properties";

	public static final String LOCATOR_FILE = System.getProperty("user.dir")
			+ "/src/test/resources/Locators/Locators.properties";

	public static final String CHROME_PATH = System.getProperty("user.dir")
			+ "/lib/chromedriver_win32/chromedriver.exe";
}
