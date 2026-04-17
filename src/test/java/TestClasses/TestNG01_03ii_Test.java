package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;
import PageClasses.MenuPage;

public class TestNG01_03ii_Test {

	@Test
	public void validateFirstSubMenu() throws InterruptedException
	{
		DriverFactory.setDriver(new ChromeDriver());
		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://demoqa.com/menu");
		new ReusuableMethods().waitForPageLoad();
		System.out.println(driver.getTitle());
		//Thread.sleep(1000);
		new MenuPage(driver).getTextFromSubItem2();
		System.out.println(Thread.currentThread().getId());
		DriverFactory.quitDriver();
	}
}
