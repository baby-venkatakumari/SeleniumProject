package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;
import PageClasses.LinksPage;

public class LinksTest {
	WebDriver driver;
	 
	@Test
	 public void verifyBrokenLinks() throws IOException
	 {
		DriverFactory.setDriver(new ChromeDriver(DriverFactory.browserConfig()));
		driver=DriverFactory.getDriver();
		driver.get("https://demoqa.com/broken");
		new ReusuableMethods().waitForPageLoad();
		System.out.println(new LinksPage(driver).fetchValidLinks());
		DriverFactory.quitDriver();
	 }
	
}
