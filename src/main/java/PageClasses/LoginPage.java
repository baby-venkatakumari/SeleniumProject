package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;

public class LoginPage {
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//*[text()=' Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*[text()=' Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//div[@id='flash-messages']//div")
	private WebElement loginMessage;
	
	ReusuableMethods utils=new ReusuableMethods();
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String login(String name, String pwd)
	{
		utils.enterText(username, name);
		utils.enterText(password, pwd);
		utils.click(loginBtn);
		return utils.getText(loginMessage);
	}
	public void clickLogout()
	{
		logoutBtn.click();
	}
	
}
