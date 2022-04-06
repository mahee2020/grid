package com.Grid.Tests;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Grid.BaseClass.TestBase;

public class GithubTest 
{
	public TestBase testBase;
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws MalformedURLException
	{
		testBase = new TestBase();
		
		driver = testBase.initializeDriver();
	}
	
	@Test(priority=1)
	public void githubTest_1()
	{		
		System.out.println("Github_Test_1 Test Method is Called");
		
		driver.get("https://www.github.com");
		
		String title = driver.getTitle();
		System.out.println("The Github_Test_1 Title is ::: " +title);
	}
	
	@Test(priority=2)
	public void githubTest_2()
	{		
		System.out.println("Github_Test_2 Test Method is Called");
		
		driver.get("https://www.github.com");
		
		String title = driver.getTitle();
		System.out.println("The Github_Test_2 Title is ::: " +title);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
} 
