package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTests extends BaseTest {
	
	@Test(priority = 1,enabled = true)
	public void testCreateCustomer() {
		logger = report.createTest("Test Create Customer");
		lp.enterUsername("admin");
		logger.pass("entered username");
		lp.enterPassword("manager");
		logger.pass("entered password");
		lp.clickLoginButton();
		logger.pass("clicked login button");
		String actual = ep.getUserLoggedIn();
		Assert.assertTrue(actual.contains("John Doe"));
		logger.pass("verified the user logged in");
		ep.clickTaskMenu();
		logger.pass("clicked task menu");
		tp.clickAddNewButton();
		logger.pass("clicked add new button");
		tp.newCustomerOption();
		logger.pass("clicked new customer option");
		tp.enterCustomerName("TestCustomer");
		logger.pass("entered customer name");
		tp.enterCustomerDescription("I am Dummy Customer Created by Automation");
		logger.pass("entered customer description");
		tp.clickCreateCustomer();
		logger.pass("clicked create customer");
		String msg = tp.getSuccessMsg();
		Assert.assertTrue(msg.contains("has been created"));
		logger.pass("verified customer created successfully");
		ep.clickLogout();
		logger.pass("logged out successfully");
	}
	
	@Test(priority = 2,enabled = true)
	public void testDeleteCustomer()
	{
		logger = report.createTest("Test Delete Customer");
		lp.enterUsername("admin");
		logger.pass("entered username");
		lp.enterPassword("manager");
		logger.pass("entered password");
		lp.clickLoginButton();
		logger.pass("clicked login button");
		String actual = ep.getUserLoggedIn();
		Assert.assertTrue(actual.contains("John Doe"));
		logger.pass("verified the user logged in");
		ep.clickTaskMenu();
		logger.pass("clicked task menu");
		tp.searchCreatedCustomer("TestCustomer");
		logger.pass("search the create customer");
		tp.clickSearchedCustomer();
		logger.pass("click on the searched customer");
		tp.clickEditButton();
		logger.pass("clicked edit button");
		tp.clickAction();
		logger.pass("clicked action button");
		tp.clickDelete();
		logger.pass("clicked delete button");
		tp.clickDeletePermanently();
		logger.pass("clicked delete permanently button");
		String msg = tp.getSuccessMsg();
		Assert.assertTrue(msg.contains("has been deleted"));
		logger.pass("verified user deleted successfully");
		ep.clickLogout();
		logger.pass("clicked logout");
	}

}






