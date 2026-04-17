package PageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.ReusuableMethods;

public class DropdownPage {

	@FindBy(xpath="//*[@id='oldSelectMenu']")
	private WebElement oldSelect;
	
	@FindBy(xpath="//*[@id='cars']")
	private WebElement carsDropdown;
	
	@FindBy(xpath="//*[text()='Select Option']//following-sibling::div/input")
	private WebElement modernSelect;
	
	@FindBy(xpath="//*[text()='Select Value']//parent::div//following::div[1]//div[contains(@class,'singleValue')]")
	private WebElement modernSelectValue;
	
	@FindBy(xpath="//*[text()='Select Title']//following-sibling::div/input")
	private WebElement modernSelectOne;
	
	@FindBy(xpath="//*[text()='Select One']//parent::div//following::div[1]//div[contains(@class,'singleValue')]")
	private WebElement modernSelectOneValue;
	
	@FindBy(xpath="//*[text()='Select...']//following-sibling::div/input")
	private WebElement modernMulitSelect;
	
	@FindBy(xpath="//*[text()='Multiselect drop down']//parent::p//following::div[1]//div[contains(@class,'multiValue')]/div[1]")
	private List<WebElement> modernMulitSelectValues;
	
	String modernSelectOptions = "//*[contains(@id,'listbox')]//div[contains(@id,'option')]";
	
	ReusuableMethods utils=new ReusuableMethods();
	public DropdownPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void makeSelections()
	{
		utils.selectByText(oldSelect, "Green");
		utils.selectByText(carsDropdown, "Audi");
		utils.click(modernSelect);
		utils.handleDynamicDrops(modernSelectOptions, "Group 1, option 1");
		utils.click(modernSelectOne);
		utils.handleDynamicDrops(modernSelectOptions, "Mr.");
		utils.click(modernMulitSelect);
		utils.handleDynamicDrops(modernSelectOptions, "Red");
		utils.handleDynamicDrops(modernSelectOptions, "Green");
	}
	
	public String getOldSelect()
	{
		WebElement ele = utils.getSelection(oldSelect);
		return utils.getText(ele);
	}
	
	public String getCarsDropdown()
	{
		WebElement ele = utils.getSelection(carsDropdown);
		return utils.getText(ele);
	}
	
	public String getModernSelect()
	{
		return utils.getText(modernSelectValue);
	}
	public String getModernSelectOne()
	{
		return utils.getText(modernSelectOneValue);
	}
	public List<String> getModernMultiSelect()
	{
		List<String> values=new ArrayList<>();
		for(WebElement ele : modernMulitSelectValues)
		{
			values.add(utils.getText(ele));
		}
		return values;
	}
}
