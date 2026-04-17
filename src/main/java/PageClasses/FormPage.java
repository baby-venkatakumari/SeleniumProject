package PageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClasses.DriverFactory;
import BaseClasses.ReusuableMethods;

public class FormPage {
	@FindBy(id="firstName")
	private WebElement firstName;

	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="userEmail")
	private WebElement email;
	
	private String gender = "//*[text()='Gender']//following::label[text()='%s']//preceding-sibling::input";
	
	@FindBy(id="userNumber")
	private WebElement mobileNumber;
	
	@FindBy(id="dateOfBirthInput")
	private WebElement dob;
	
	@FindBy(xpath="//select[contains(@class,'year-select')]")
	private WebElement year;
	
	@FindBy(xpath="//select[contains(@class,'month-select')]")
	private WebElement month;
	
	String date = "//div[contains(@class,'datepicker__day') and (text()='%s')]";
	
	String datePickerPopper = "//div[@class='react-datepicker-popper']";
	
	@FindBy(xpath="//input[contains(@class,'subjects')]")
	private WebElement subjects;
	
	String hobbies = "//label[text()='%s']//preceding-sibling::input[contains(@id,'hobbies')]";
	
	@FindBy(id="currentAddress")
	private WebElement currentAddress;
	
	@FindBy(xpath="//div[text()='Select State']//following-sibling::div/input")
	private WebElement state;
	
	@FindBy(xpath="//div[text()='Select City']//following-sibling::div/input")
	private WebElement city;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
//	
//	@FindBy(xpath="//*[contains(@class,'modal-title')]")
//	private WebElement msg;
	
	String msg = "//*[contains(@class,'modal-title')]";
	
	@FindBy(xpath="//input[@id='uploadPicture']")
	private WebElement uploadPicture;
	
	String autoOptions="//*[contains(@class,'auto-complete__option')]";
	
	ReusuableMethods utils=new ReusuableMethods();
	public FormPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void register(String fname, String lname, String filePath) throws InterruptedException
	{
		utils.enterText(firstName, fname);
		utils.enterText(lastName, lname);
		WebElement genderElement = utils.generateWebElement(gender, "Male");
		utils.click(genderElement);
		utils.enterText(mobileNumber, "9849495008");
		utils.enterText(email, "testUser@example.com");
		
		utils.click(dob);
		utils.waitForElement(datePickerPopper);
		utils.selectByText(year, "1993");
		utils.selectByText(month, "August");
		WebElement dateElement=utils.generateWebElement(date, String.valueOf(15));
		utils.click(dateElement);
		
		utils.enterText(subjects, "English");
		utils.handleDynamicDrops(autoOptions, "English");
		
		WebElement eleHobbies = utils.generateWebElement(hobbies, "Reading");
		utils.click(eleHobbies);
		utils.enterText(currentAddress, "Hyderabad");
		utils.enterText(uploadPicture, filePath);
		
		utils.enterText(state, "Uttar Pradesh"+Keys.ENTER);
		utils.enterText(city, "Agra"+Keys.ENTER);

		Thread.sleep(5000);
		utils.scrollIntoView(submitBtn);
		utils.click(submitBtn);
	}
	public String validateTheSubmission() 
	{
		WebElement ele=utils.waitForElement(msg);
		return utils.getText(ele);
	}
	
}
