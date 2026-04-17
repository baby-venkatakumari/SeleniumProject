package TestClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;
import PageClasses.Selenium03_03_Page;

public class Selenium03_03_Test {
	WebDriver driver;
	//@Test
	public void validateInfiniteScroll() throws InterruptedException
	{
		DriverFactory.setDriver(new ChromeDriver());
		driver=DriverFactory.getDriver();
		driver.get("https://the-internet.herokuapp.com/infinite_scroll");
		new ReusuableMethods().waitForPageLoad();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int count=1;
		while(count<=10)
		{
			js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
			Thread.sleep(1000);
			count++;
		}
		new Selenium03_03_Page(driver).fetchTextFromScroll();
		DriverFactory.quitDriver();
	}
	
	//@Test
	public void validateScroll()
	{
		DriverFactory.setDriver(new ChromeDriver());
		driver=DriverFactory.getDriver();
		driver.get("https://the-internet.herokuapp.com/infinite_scroll");
		new ReusuableMethods().waitForPageLoad();
		new ReusuableMethods().scroll();
		new Selenium03_03_Page(driver).fetchTextFromScroll();
		DriverFactory.quitDriver();
	}
}
