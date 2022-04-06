package com.Grid.BaseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase 
{
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initializeDriver() throws MalformedURLException 
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.merge(capabilities);
		
		String hubUrl = "http://localhost:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubUrl), chromeOptions);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		tdriver.set(driver);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() 
	{
		return tdriver.get();
	}
}
