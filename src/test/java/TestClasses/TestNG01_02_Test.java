package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;
import PageClasses.LoginPage;

public class TestNG01_02_Test {
	WebDriver driver;
	 
	// @Test
	 public void loginFunctionality_testng0102()
	 {
		DriverFactory.setDriver(new ChromeDriver());
		driver=DriverFactory.getDriver();
		LoginPage loginPageObj=new LoginPage(driver);
		driver.get("https://the-internet.herokuapp.com/login");
		new ReusuableMethods().waitForPageLoad();
		Assert.assertEquals(driver.getTitle(), "The Internet");
		String loginMsg = loginPageObj.login("tomsmith", "SuperSecretPassword!");
		if(loginMsg.contains("logged in"))
		{
			System.out.println(loginMsg);
		}
		DriverFactory.quitDriver();
	 }
}
