package com.acti.pages;

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
	
// *************************************** Page Initialization ******************************************* //
	
	public EnterPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
// *************************************** Page Methods ************************************************* //

}
