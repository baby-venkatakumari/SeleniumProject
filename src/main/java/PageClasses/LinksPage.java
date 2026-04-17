package PageClasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.ReusuableMethods;

public class LinksPage {

	@FindBy(xpath="//a")
	private List<WebElement> links;
	
	ReusuableMethods utils= new ReusuableMethods();
	public LinksPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void identifyLinks()
	{
		
	}
	public List<String> fetchValidLinks() throws IOException
	{
		List<String> validLinks =new ArrayList<>();
		System.out.println("Total links :"+links.size());
		for(WebElement ele : links)
		{
			String url=ele.getAttribute("href");
			if(verifyLink(url))
			{
				validLinks.add(url);
			}
		}
		System.out.println("Valid links :"+validLinks.size());
		return validLinks;
	}
	public boolean verifyLink(String str) throws IOException
	{
		boolean flag=true;
		URL url=new URL(str);
		HttpURLConnection http=(HttpURLConnection) url.openConnection();
		http.connect();
		if(http.getResponseCode()>=400)
		{
			System.out.println("broken link "+str);
			flag=false;
		}
		return flag;
	}
}
