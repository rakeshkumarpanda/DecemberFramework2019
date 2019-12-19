package com.seleniumeasy.BusinessLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.seleniumeasy.CommonLib.CommonFunctions;
import com.seleniumeasy.ObjectRepository.HomePageElements;
import com.seleniumeasy.ObjectRepository.LandingPageElements;
import com.seleniumeasy.ObjectRepository.SubmitFormPageElements;

public class BusinessFunctionalities extends CommonFunctions
{
	WebDriver driver;
	LandingPageElements landingPageElements;
	HomePageElements homePageElements;
	SubmitFormPageElements submitFormPageElements;
	
	public BusinessFunctionalities(WebDriver driver)
	{
		this.driver=driver;
		landingPageElements = PageFactory.initElements(driver, LandingPageElements.class);
		homePageElements = PageFactory.initElements(driver, HomePageElements.class);
		submitFormPageElements = PageFactory.initElements(driver, SubmitFormPageElements.class);
	}
	
	
	
	public void submitFormScenario(String firstName, String lastName, String email, String phone, String state) throws InterruptedException
	{
		// Functionality Starts
		// Landing Page Element
		clickElement(landingPageElements.getDemoWebsiteLink(), "Demo Website Link");

		// Home Page Elements
		Thread.sleep(5000);
		clickElement(homePageElements.getInputForm(), "Input Forms");
		WebElement inputFormSubmit = homePageElements.getInputFormSubmit();
		// Explicit Wait
		explicitWait(driver, inputFormSubmit);
		clickElement(inputFormSubmit, "Input Form Submit");

		// Submit Form Page
		enterText(submitFormPageElements.getFirstNameField(), firstName, "First Name Field");
		enterText(submitFormPageElements.getLastNameField(), lastName, "Last Name Field");
		enterText(submitFormPageElements.getEmailField(), email, "E-Mail Field");
		enterText(submitFormPageElements.getPhoneNumberField(), phone, "Phone Number Field");
		WebElement stateDropdown = submitFormPageElements.getStateDropdown();
		selectOption(stateDropdown, state, "State Dropdown");
		WebElement yesRadioButton = submitFormPageElements.getYesRadioButton();
		scrollDown(driver, yesRadioButton, "Yes Radio Button");
		clickElement(yesRadioButton, "Yes Radio Button");
		Thread.sleep(5000);
		clickElement(submitFormPageElements.getSeleniumEasyImage(), "Selenium Easy Image");
		// Functionality Ends
	}

}
