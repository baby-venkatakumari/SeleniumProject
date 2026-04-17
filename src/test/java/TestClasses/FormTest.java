package TestClasses;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import PageClasses.FormPage;

public class FormTest {
	WebDriver driver = DriverFactory.getDriver();
	FormPage formPageObj = new FormPage(driver);
	//@Test
	public void fillTheFormToRegister() throws InterruptedException 
	{
		driver.get("https://demoqa.com/automation-practice-form");
		String path="C:\\Users\\BabyVenkataKumariPil\\Downloads\\Testing.txt";
		formPageObj.register("test", "user", path);
		Assert.assertEquals(formPageObj.validateTheSubmission(), "Thanks for submitting the form");
		driver.quit();
	}
}
