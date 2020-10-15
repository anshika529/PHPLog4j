package com.atmecs.phptravels.pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.phptravels.constants.Constants;
import com.atmecs.phptravels.helpers.ElementHelpers;
import com.atmecs.phptravels.utils.PropertyReader;
import com.atmecs.phptrtavels.testsuit.BaseTest;

public class ChatClass extends BaseTest {
	Properties Location_path, Data_path;

	public void Chatbot() throws InterruptedException {
		Logger log = Logger.getLogger(ChatClass.class);

		Location_path = PropertyReader.readProperty(Constants.LOCATOR_FILE);
		Data_path = PropertyReader.readProperty(Constants.TestDATA_FILE);
		log.info("Switching to iframe");
		WebElement widget = driver.findElement(By.id(Location_path.getProperty("Frame_Id")));
		widget.click();
		widget.isDisplayed();
		log.info("Chat-Widget Dispalayed...Assertion Passed");
		driver.switchTo().frame(Location_path.getProperty("Frame_Id"));

		WebDriverWait wait = new WebDriverWait(driver, 40);
		log.info("ChatWidget Displayed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Location_path.getProperty("ChatWidget"))));
		log.info("ChatWidget Clicked");

		ElementHelpers.jsClick(driver, Location_path.getProperty("ChatWidget"));
		log.info("Sending Name");
		ElementHelpers.sendKeyById(driver, Location_path.getProperty("NameData"), Data_path.getProperty("Name"));
		log.info("Sending WhatsApp Number");
		ElementHelpers.ElementSendKeys(driver, Location_path.getProperty("WhatsApp"),
				Data_path.getProperty("WhatsAppNo"));
		log.info("Sending Email");
		ElementHelpers.sendKeyById(driver, Location_path.getProperty("EmailData"), Data_path.getProperty("Email"));

		ElementHelpers.selectFromDropDown(driver, Location_path.getProperty("Dropdown"),
				Location_path.getProperty("value"));
		log.info("Chat has been Started");
		ElementHelpers.jsClick(driver, Location_path.getProperty("StartChat"));

	}

}
