package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
	
	@Test(enabled = false)
	public void testLoginPageTitle()
	{
		logger = report.createTest("Test Login Page Title");
		String expected ="actiTIME - Login";
		String actual = lp.getLoginPageTitle();
		logger.pass("captured page title");
		System.out.println(expected);
		Assert.assertEquals(actual, expected);	
		logger.pass("verified the login page title");
	}
	
	@Test(enabled = false)
	public void testActiImgDisplayed()
	{
		logger = report.createTest("Test Login Page Title");
		boolean flag = lp.verifyActiImg();
		logger.pass("identified the image");
		Assert.assertTrue(flag);
		logger.pass("verified logo is displayed");
	}
	
	@Test(enabled = false)
	public void testForgotPasswordDisplayed()
	{
		logger = report.createTest("Test ForgotPassword Link is Displayed");
		boolean flag = lp.verifyForgotpasswordLink();
		logger.pass("identified the forgotpassword link");
		Assert.assertTrue(flag);
		logger.pass("forgotpassword link logo is displayed");
	}
	
	@Test(enabled = false)
	public void testLoginFunction()
	{
		logger = report.createTest("Test ForgotPassword Link is Displayed");
		lp.enterUsername("admin");
		logger.pass("entered username");
		lp.enterPassword("manager");
		logger.pass("entered password");
		lp.clickLoginButton();
		logger.pass("clicked login button");
		String actual = ep.getUserLoggedIn();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("John Doe"));
		logger.pass("verified the user logged in");
		ep.clickLogout();
		logger.pass("clicked logout");
	}
	
	@Test(enabled = false)
	public void testLoginInvalidCredientials() throws InterruptedException
	{
		logger = report.createTest("Test ForgotPassword Link is Displayed");
		lp.enterPassword("admin");
		logger.pass("entered username");
		lp.clickLoginButton();
		logger.pass("clicked login button without entering password");
		Thread.sleep(3000);
		String errmsg = lp.getErrMsgText();
		logger.pass("captured the error message");
		System.out.println(errmsg);
		Assert.assertTrue(errmsg.contains("Username or Password is invalid"));
		logger.pass("verified the error message");
	}
	
	@Test(enabled = true)
	public void testLoginInvalidCredientials1() throws InterruptedException
	{
		logger = report.createTest("Test ForgotPassword Link is Displayed");
		lp.enterPassword("admin");
		logger.pass("entered username");
		lp.enterPassword("damager");
		logger.pass("entered password");
		lp.clickLoginButton();
		logger.pass("clicked login button");
		Thread.sleep(3000);
		String actual = ep.getUserLoggedIn();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("John Doe"));
		logger.pass("verified the user logged in");
		ep.clickLogout();
		logger.pass("clicked logout");
	}

}





