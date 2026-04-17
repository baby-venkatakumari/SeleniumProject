package BaseClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusuableMethods {
	WebDriver driver=DriverFactory.getDriver();
	WebDriverWait wait;
	public void enterText(WebElement ele,String str)
	{
		ele.clear();
		ele.sendKeys(str);
	}
	public void click(WebElement ele)
	{
		try {
			ele.click();
		}
		catch(ElementClickInterceptedException e)
		{
			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".overlay, .spinner")));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
			ele.click();
		}
		
	}
	public void waitForPageLoad()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingSpinner")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner")));
	}
	public void launchUrl(String url)
	{
		driver.get(url);
	}
	public WebElement generateWebElement(String strElement, String inputValue)
	{
		WebElement ele=driver.findElement(By.xpath(strElement.replace("%s", inputValue)));
		return ele;
	}
	public String getText(WebElement ele)
	{
		return ele.getText();
	}
	
	public WebElement waitForElement(String str)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
		return ele;
	}
	
	public void selectByText(WebElement ele, String str)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(str);
	}
	
	public WebElement getSelection(WebElement ele)
	{
		Select s=new Select(ele);
		return s.getFirstSelectedOption();
	}
	public void handleDynamicDrops(String str, String expectedValue)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(str)));
		for(WebElement ele : list)
		{
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			if(ele.getText().contains(expectedValue))
			{
				ele.click();
				return;
			}
		}
	}
	public void handlingActions(WebElement mainEle, WebElement ele1, WebElement ele2)
	{
		Actions act=new Actions(driver);
		act.moveToElement(mainEle).moveToElement(ele1).moveToElement(ele2)
		.build().perform();
		
		String str=ele2.getText();
		System.out.println(str);
	}
	
	public void scrollIntoView(WebElement ele)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
		
	}
	
	public List<WebElement> getWebElements(String str)
	{
		return driver.findElements(By.xpath(str));
	}
	public void scrollDown()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");	
	}
	
	public void switchToAlert(String alertAction, String promptMsg, int numberOfSeconds) 
	{
		waitForAlert(numberOfSeconds);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		switch(alertAction)
		{
			case "prompt" : 
				alert.sendKeys(promptMsg);
				alert.accept();
				break;
			case "accept" : 
				alert.accept();
				break;
			case "dismiss" : 
				alert.dismiss();
				break; 
			default : break;
		}
	}
	
	public void waitForAlert(int numberOfSeconds)
	{
		if(numberOfSeconds==0)
			numberOfSeconds=10;
		wait = new WebDriverWait(driver,Duration.ofSeconds(numberOfSeconds));
		wait.until(ExpectedConditions.alertIsPresent());		
	}
	public void verifyTableData(String str, Set<String> expectedData)
	{
		List<WebElement> rows=driver.findElements(By.xpath(str+"//tr"));
		for(int i=1;i<rows.size();i++)
		{
			Set<String> rowData=new TreeSet<>();
			List<WebElement> data=driver.findElements(By.xpath(str+"//tr["+i+"]//td"));
			for(int j=0;j<data.size()-1;j++)
			{
				rowData.add(data.get(j).getText());
			}
			if(rowData.equals(expectedData))
			{
				System.out.println("Expected data has been loaded to the table successfully");
				break;
			}
		}
	}
	
	public void scroll()
	{
		Actions act= new Actions(driver);
		int count=1;
		while(count<=10)
		{
			act.sendKeys(Keys.PAGE_DOWN).pause(Duration.ofSeconds(1)).build().perform();
			count++;
		}
	}
	
}
