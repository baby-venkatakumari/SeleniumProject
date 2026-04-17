package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.ReusuableMethods;

public class Selenium03_03_Page {
	
	@FindBy(xpath="//*[@class='jscroll-inner']")
	private List<WebElement> eleText;
	
	public Selenium03_03_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	ReusuableMethods utils = new ReusuableMethods();
	public void fetchTextFromScroll()
	{
		for(WebElement ele : eleText)
		{
			System.out.println(utils.getText(ele));
		}
	}
	
	
	
}
