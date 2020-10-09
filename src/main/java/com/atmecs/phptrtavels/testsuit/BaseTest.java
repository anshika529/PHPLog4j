package com.atmecs.phptrtavels.testsuit;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.atmecs.phptravels.constants.Constants;
import com.atmecs.phptravels.utils.PropertyReader;

public class BaseTest {
	public static WebDriver driver;
	public static Properties properties;
	String baseUrl;

	@BeforeMethod

	public void invokebrowser() {
		properties = PropertyReader.readProperty(Constants.TestDATA_FILE);

		 baseUrl =properties.getProperty("url"); 
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);	
		driver = new ChromeDriver();
		driver.get("url");
		String actualTitle = driver.getTitle();

		String expectedTitle = "PHPTRAVELS booking script and system for hotels airline flights tours cars online application - PHPTRAVELS";
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
