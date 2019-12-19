package com.seleniumeasy.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements 
{
	@FindBy(xpath = "//li[@class='dropdown']/a[contains(text(),'Input Forms')]")
	private WebElement inputForm;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Input Form Submit')]")
	private WebElement inputFormSubmit;
	public WebElement getInputForm() {
		return inputForm;
	}
	public WebElement getInputFormSubmit() {
		return inputFormSubmit;
	}

}
