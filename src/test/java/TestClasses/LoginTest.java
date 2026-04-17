package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;
import PageClasses.LoginPage;

public class LoginTest {
	 
	 WebDriver driver;
	 
	//@Test
	 public void loginFunctionality_HappyPath_LoginTest()
	 {
		DriverFactory.setDriver(new EdgeDriver());
		driver=DriverFactory.getDriver();
		LoginPage loginPageObj=new LoginPage(driver);
		driver.get("https://the-internet.herokuapp.com/login");
		new ReusuableMethods().waitForPageLoad();
		String loginMsg = loginPageObj.login("tomsmith", "SuperSecretPassword!");
		if(loginMsg.contains("logged in"))
		{
			System.out.println(loginMsg);
			loginPageObj.clickLogout();
		}
		DriverFactory.quitDriver();
	 }
	 
	 //@Test
	 public void loginFunctionality_UnhappyPath()
	 {
		 driver=DriverFactory.getDriver();
		 driver.get("https://the-internet.herokuapp.com/login");
		 
		 String loginMsg = new LoginPage(driver).login("tomsmith", "SuperSecretPassword");
		 if(loginMsg.contains("invalid"))
		 {
			 System.out.println(loginMsg);
		 }
		 driver.quit();
	 }
	 
}
