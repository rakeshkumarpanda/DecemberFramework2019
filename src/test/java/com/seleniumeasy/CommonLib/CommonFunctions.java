package com.seleniumeasy.CommonLib;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CommonFunctions 
{
	public void clickElement(WebElement element, String elementName)
	{
		try
		{
			if(element.isDisplayed() && element.isEnabled())
			{
				element.click();
				Reporter.log(elementName+" is clicked");
			}	
		}
		catch(NoSuchElementException e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		catch(Exception e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		
	}
	public void enterText(WebElement element, String text, String elementName)
	{
		try
		{
			if(element.isDisplayed() && element.isEnabled())
			{
				element.clear();
				element.sendKeys(text);
				Reporter.log(elementName+" is entered with value "+text);
			}	
		}
		catch(NoSuchElementException e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		catch(Exception e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		
	}
	public void selectOption(WebElement element, String option, String elementName)
	{
		try
		{
			if(element.isDisplayed() && element.isEnabled())
			{
				Select sel = new Select(element);
				sel.selectByVisibleText(option);
				Reporter.log(elementName+" is selected with option "+option);
			}	
		}
		catch(NoSuchElementException e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		catch(Exception e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}	
	}
	public void scrollDown(WebDriver driver, WebElement element, String elementName)
	{
		try
		{
			if(element.isDisplayed() && element.isEnabled())
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView()", element);
				Reporter.log(" Page is scrolled upto "+elementName);
			}	
		}
		catch(NoSuchElementException e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		catch(Exception e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
	}
	public void explicitWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
