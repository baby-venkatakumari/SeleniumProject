package TestClasses;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import PageClasses.DropdownPage;

public class DropdownTest {
	WebDriver driver = DriverFactory.getDriver();
	DropdownPage obj=new DropdownPage(driver);
	//@Test
	public void dropdownTest() throws InterruptedException
	{
		driver.get("https://demoqa.com/select-menu");
		obj.makeSelections();
		Assert.assertEquals(obj.getOldSelect(), "Green");
		Assert.assertEquals(obj.getCarsDropdown(), "Audi");
		Assert.assertEquals(obj.getModernSelect(), "Group 1, option 1");
		Assert.assertEquals(obj.getModernSelectOne(), "Mr.");
		Assert.assertEquals(obj.getModernMultiSelect(), new ArrayList<String>(Arrays.asList("Red","Green")));
		driver.quit();
	}
}
