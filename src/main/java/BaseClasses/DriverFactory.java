package BaseClasses;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();

	private DriverFactory()	{
	}
	
	public static void setDriver(WebDriver browserDriver)
	{
		if(driver.get()==null)
		{
			driver.set(browserDriver);
			driver.get().manage().window().maximize();
		}
	}
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	public static void quitDriver()
	{
		if(driver.get()!=null)
		{
			driver.get().quit();
			driver.remove();
		}
	}
	public static ChromeOptions browserConfig()
	{
		ChromeOptions options=new ChromeOptions();
		HashMap<String, String> prefs = new HashMap<>();
		prefs.put("download.default_directory", System.getProperty("user.dir"));
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--headless");
		return options;
	}

}
