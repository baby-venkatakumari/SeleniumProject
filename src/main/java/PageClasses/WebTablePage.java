package PageClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.ReusuableMethods;

public class WebTablePage {
	@FindBy(xpath="//*[text()='Add']")
	private WebElement addBtn;
	
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="userEmail")
	private WebElement email;
	
	@FindBy(id="age")
	private WebElement age;
	
	@FindBy(id="salary")
	private WebElement salary;
	
	@FindBy(id="department")
	private WebElement department;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	String table = "//table";
	
	ReusuableMethods utils=new ReusuableMethods();
	
	public WebTablePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addNewRow(Map<String, String> data)
	{
		utils.click(addBtn);
		utils.enterText(firstName, data.get("fname"));
		utils.enterText(lastName, data.get("lname"));
		utils.enterText(email, data.get("email"));
		utils.enterText(age, data.get("age"));
		utils.enterText(salary, data.get("salary"));
		utils.enterText(department, data.get("department"));
		utils.click(submitBtn);
	}
	public void verifyNewlyAddedRow(Map<String, String> data)
	{
		Set<String> expectedData=new TreeSet<>();
		Set<String> keys = data.keySet();
		for(String key : keys)
		{
			expectedData.add(data.get(key));
		}
		utils.verifyTableData(table, expectedData);
	}
}
