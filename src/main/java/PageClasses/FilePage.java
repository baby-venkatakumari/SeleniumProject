package PageClasses;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.ReusuableMethods;

public class FilePage {
	@FindBy(xpath="//input[@id='uploadFile']")
	private WebElement uploadFile;
	
	@FindBy(xpath="//*[@id='uploadedFilePath']")
	private WebElement uploadedFilePath;
	
	@FindBy(xpath="//*[text()='Download']")
	private WebElement downloadFile;
	
	ReusuableMethods utils=new ReusuableMethods();
	public FilePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void validateFileUpload(String path)
	{
		utils.enterText(uploadFile, path);
		try
		{
			String filePath=utils.getText(uploadedFilePath);
			if(!filePath.isEmpty())
			{
				System.out.println("File uploaded successfully");
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("File did not upload successfully");
		} 
	}
	public void validateFileDownload() throws InterruptedException
	{
		File file=new File(System.getProperty("user.dir"));
		File[] beforeDownload=file.listFiles();
		List<File> before=new ArrayList<>(Arrays.asList(beforeDownload));
		utils.click(downloadFile);
		
		Thread.sleep(1000);
		File[] afterDownload=file.listFiles();
		List<File> after=new ArrayList<>(Arrays.asList(afterDownload));
		if(after.removeAll(before))
			System.out.println("Downloaded file "+after);
	}
}
