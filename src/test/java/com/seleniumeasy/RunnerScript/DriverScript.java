package com.seleniumeasy.RunnerScript;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seleniumeasy.BrowserHandling.BrowserHandling;
import com.seleniumeasy.BusinessLib.BusinessFunctionalities;

public class DriverScript extends BrowserHandling
{
	BusinessFunctionalities businessFunctionalities;
	
	@BeforeClass
	public void initObjects()
	{
		businessFunctionalities = new BusinessFunctionalities(driver);
	}
	
	@Test(dataProvider = "Submit Form Data", dataProviderClass = com.seleniumeasy.DataProvider.DataCollection.class)
	public void submitFormTest(String firstName, String lastName, String email, String phone, String state) throws InterruptedException
	{ 
		businessFunctionalities.submitFormScenario(firstName, lastName, email, phone, state);
		System.out.println("This is for Pull Request");
	}

}
