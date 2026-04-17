package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;

public class TestNG01_01_Test {
	WebDriver driver;
	//@BeforeMethod
	public void launchBrowser()
	{
		DriverFactory.setDriver(new ChromeDriver());
		driver=DriverFactory.getDriver();
		driver.get("https://google.com/");
	}
	//@AfterMethod
	public void closeBrowser()
	{
		DriverFactory.quitDriver();
	}
	//@Test
	public void validateTitle()
	{
		Assert.assertEquals(driver.getTitle(),"Google");
	}
	//@Test
	public void validatePageLoad()
	{
		new ReusuableMethods().waitForPageLoad();
	}

}
