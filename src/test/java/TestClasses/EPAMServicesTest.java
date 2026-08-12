package TestClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;

public class EPAMServicesTest {
	WebDriver driver;

	@Test
	public void verifyClientWorkNavigationFromServices() {
		DriverFactory.setDriver(new ChromeDriver(DriverFactory.browserConfig()));
		driver = DriverFactory.getDriver();
		driver.get("https://www.epam.com/");

		ReusuableMethods utils = new ReusuableMethods();
		utils.waitForPageLoad();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions actions = new Actions(driver);

		WebElement servicesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//header//a[normalize-space()='Services' or normalize-space()='Services ']")));
		actions.moveToElement(servicesMenu).pause(Duration.ofMillis(300)).perform();

		WebElement clientWorkLink = wait.until(ExpectedConditions.elementToBeClickable(
			By.xpath("//*[self::a or self::button][contains(normalize-space(),'Explore Our Client Work')]")));
		clientWorkLink.click();

		WebElement clientWorkText = wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//*[self::h1 or self::h2 or self::h3 or self::p or self::span][normalize-space()='Client Work' or contains(normalize-space(),'Client Work')]") ));

		Assert.assertTrue(clientWorkText.isDisplayed(), "Expected 'Client Work' text to be visible on the destination page.");
		DriverFactory.quitDriver();
	}
}
