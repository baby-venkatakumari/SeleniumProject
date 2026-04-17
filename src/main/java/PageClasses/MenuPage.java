package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.ReusuableMethods;

public class MenuPage {
	@FindBy(xpath="//*[text()='Main Item 2']//following::a[text()='SUB SUB LIST »']//following::a[1]")
	private WebElement subItem1;
	
	@FindBy(xpath="//*[text()='Main Item 2']//following::a[text()='SUB SUB LIST »']//following::a[2]")
	private WebElement subItem2;
	
	@FindBy(xpath="//*[text()='Main Item 2']")
	private WebElement mainItem2;
	
	@FindBy(xpath="//*[text()='Main Item 2']//following-sibling::ul//child::li//a[text()='SUB SUB LIST »']")
	private WebElement mainItem2Options;
	
	@FindBy(xpath="//a[text()='SUB SUB LIST »']//following-sibling::ul/li/a[text()='Sub Sub Item 1']")
	private WebElement mainItem2SubItem1;
	
	@FindBy(xpath="//a[text()='SUB SUB LIST »']//following-sibling::ul/li/a[text()='Sub Sub Item 2']")
	private WebElement mainItem2SubItem2;
	
	ReusuableMethods utils=new ReusuableMethods();
	
	public MenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getTextFromSubItem1()
	{
		utils.waitForPageLoad();
		utils.handlingActions(mainItem2, mainItem2Options, mainItem2SubItem1);
	}
	
	public void getTextFromSubItem2()
	{
		utils.waitForPageLoad();
		utils.handlingActions(mainItem2, mainItem2Options, mainItem2SubItem2);
	}
	
}
