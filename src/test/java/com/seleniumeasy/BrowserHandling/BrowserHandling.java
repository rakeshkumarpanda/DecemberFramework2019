package com.seleniumeasy.BrowserHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BrowserHandling 
{
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void browserLaunch(String browser)
	{
		// BrowserLaunching
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\BrowserServers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("headless"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\BrowserServers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.setHeadless(true);
			driver = new ChromeDriver(option);
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/");
	}
	
	@AfterTest
	public void browserClose() throws InterruptedException
	{
		// BrowserClosing
		Thread.sleep(5000);
		driver.quit();
	}

}
