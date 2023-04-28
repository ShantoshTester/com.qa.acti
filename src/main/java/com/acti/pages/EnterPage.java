package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
 * Name: EnterPage
 * Description: Manages the locators and methods of enter page
 * Developed By: Satya
 * Reviewed By: Shantosh
 * Date Review : 04-27-2023
 */


public class EnterPage extends DriverScript {
	
// *************************************** Page Locators ************************************************* //
	
	@FindBy(id = "logoutLink") WebElement logoutLink;
	@FindBy(xpath = "//a[@class='userProfileLink username ']") WebElement userloggedText;
	@FindBy(xpath = "//div[@id='container_tasks']") WebElement menuTask;
	@FindBy(xpath = "//div[@id='container_reports']") WebElement menuReports;
	@FindBy(xpath = "//a[@class='content users']") WebElement menuUsers;
	
// *************************************** Page Initialization ******************************************* //
	
	public EnterPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
// *************************************** Page Methods ************************************************* //
	
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public String getUserLoggedIn()
	{
		return userloggedText.getText();
	}
	
	public void clickTaskMenu()
	{
		menuTask.click();
	}

}
