package TestClasses;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;
import PageClasses.WebTablePage;

public class TestNG03_03_Test {
	WebDriver driver;
	Map<String,String> data=new HashMap<>();
	WebTablePage obj;
	//@Test
	public void launchBrowser()
	{
		DriverFactory.setDriver(new ChromeDriver());
		driver=DriverFactory.getDriver();
		driver.get("https://demoqa.com/webtables");
		new ReusuableMethods().waitForPageLoad();
		Assert.assertEquals(driver.getTitle(), "demosite");
	}
	//@Test(dependsOnMethods = {"launchBrowser"})
	public void addNewRowToWebTable()
	{
		data.put("fname","test");
		data.put("lname","user");
		data.put("email","testuser@example.com");
		data.put("age","56");
		data.put("salary","20000");
		data.put("department","it");
		obj=new WebTablePage(driver);
		obj.addNewRow(data);
	}
	
	//@Test(dependsOnMethods = {"addNewRowToWebTable"})
	public void verifyAddedDetails()
	{
		obj.verifyNewlyAddedRow(data);
		DriverFactory.quitDriver();
	}
}
