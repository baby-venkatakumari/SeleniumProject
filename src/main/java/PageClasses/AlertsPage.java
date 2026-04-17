package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.ReusuableMethods;

public class AlertsPage {

	@FindBy(xpath="//*[@id='alertButton']")
	private WebElement alertBtn;
	
	@FindBy(xpath="//*[@id='timerAlertButton']")
	private WebElement timerAlertBtn;
	
	@FindBy(xpath="//*[@id='confirmButton']")
	private WebElement confirmAlertBtn;
	
	@FindBy(xpath="//*[@id='promtButton']")
	private WebElement promptAlertBtn;
	
	@FindBy(xpath="//span[@id='confirmResult']")
	private WebElement confirmResult;
	
	@FindBy(xpath="//span[@id='promptResult']")
	private WebElement promptResult;
	
	ReusuableMethods utils=new ReusuableMethods();
	public AlertsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void validateNormalAlert() throws InterruptedException
	{
		utils.click(alertBtn);
		utils.switchToAlert("accept", "" ,0);
	}
	public void validateTimerAlert() throws InterruptedException
	{
		utils.click(timerAlertBtn);
		utils.switchToAlert("accept", "" , 5);
	}
	public void validateConfirmAlert() throws InterruptedException
	{
		utils.click(confirmAlertBtn);
		utils.switchToAlert("dismiss", "" , 0);
		System.out.println(utils.getText(confirmResult));
		
	}
	public void validatePromptAlert(String prompt) throws InterruptedException
	{
		utils.click(promptAlertBtn);
		utils.switchToAlert("prompt", prompt , 0);
		System.out.println(utils.getText(promptResult));
	}
}
