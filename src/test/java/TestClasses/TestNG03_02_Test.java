package TestClasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;
import PageClasses.LoginPage;

public class TestNG03_02_Test {
	WebDriver driver;
	//@Test(dataProvider="getData")
	public void loginFunctionality_testng0302(String username, String password)
	{
		DriverFactory.setDriver(new FirefoxDriver());
		driver=DriverFactory.getDriver();
		LoginPage loginPageObj=new LoginPage(driver);
		driver.get("https://the-internet.herokuapp.com/login");
		new ReusuableMethods().waitForPageLoad();
		Assert.assertEquals(driver.getTitle(), "The Internet");
		String loginMsg = loginPageObj.login(username,password);
		if(loginMsg.contains("logged in"))
		{
			System.out.println(loginMsg);
			loginPageObj.clickLogout();
		}
		DriverFactory.quitDriver();

	}
	
	//@DataProvider
	public Object[][] getData()
	{	
		return new Object[][] { 
			{"toesmith", "superstrong"},
			{"tomsmith","SuperSecretPassword!"}
		};
	}
}
