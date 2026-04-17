package TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import BaseClasses.DriverFactory;
import PageClasses.FilePage;

public class FileTest {
	WebDriver driver = DriverFactory.getDriver();
	FilePage obj=new FilePage(driver);
	//@Test
	public void fileUploadDownloadTest() throws InterruptedException
	{
		driver.get("https://demoqa.com/upload-download");
		String path="C:\\Users\\BabyVenkataKumariPil\\Downloads\\Testing.txt";
		obj.validateFileUpload(path);
		obj.validateFileDownload();
		driver.quit();
	}
}
