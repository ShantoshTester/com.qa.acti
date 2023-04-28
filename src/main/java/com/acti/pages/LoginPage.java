package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
 * Name: LoginPage
 * Description: Manages the locators and methods of loginpage
 * Developed By: Aarthi
 * Reviewed By: Satya
 * Date Reviewd : 04-26-2023
 */

public class LoginPage extends DriverScript {
	
// *************************************** Page Locators ************************************************* //
	
	@FindBy(id = "username") WebElement usernameTextbox;
	@FindBy(name = "pwd") WebElement passwordTextbox;
	@FindBy(xpath = "//div[text()='Login ']") WebElement loginButton;
	@FindBy(className = "errormsg") WebElement errmsgText;
	@FindBy(linkText = "Forgot your password?") WebElement forgotpasswordLink;
	@FindBy(xpath = "//div[@class='atLogoImg']") WebElement actiImg;
	
// *************************************** Page Initialization ******************************************* //
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
// *************************************** Page Methods ************************************************* //
	
	public void enterUsername(String username) 
	{
		usernameTextbox.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLoginButton() 
	{
		loginButton.click();
	}
	
	public String getErrMsgText() 
	{
		return errmsgText.getText();
	}
	
	public boolean verifyForgotpasswordLink()
	{
		return forgotpasswordLink.isDisplayed();
	}
	
	public boolean verifyActiImg() 
	{
		return actiImg.isDisplayed();
	}
	
	public String getLoginPageTitle() 
	{
		return driver.getTitle();
	}

}
