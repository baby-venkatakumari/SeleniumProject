package TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import PageClasses.AlertsPage;

public class AlertsTest {
	WebDriver driver = DriverFactory.getDriver();
	AlertsPage obj=new AlertsPage(driver);
	//@Test
	public void validateAlerts() throws InterruptedException
	{
		driver.get("https://demoqa.com/alerts#google_vignette");
		obj.validateNormalAlert();
		obj.validateConfirmAlert();
		obj.validatePromptAlert("testUser");
		obj.validateTimerAlert();
		driver.quit();
	}
}
