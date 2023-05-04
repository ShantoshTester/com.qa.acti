package com.acti.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskPage;
import com.acti.utils.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends DriverScript {
	
	public static ExtentHtmlReporter extent;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	LoginPage lp;
	EnterPage ep;
	TaskPage tp;
	
	@BeforeSuite
	public void reportSetup()
	{
		extent = new ExtentHtmlReporter("./reports/actiindex.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void preTest()
	{
		initApplication();
		lp = new LoginPage();
		ep = new EnterPage();
		tp = new TaskPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try
			{
				logger.fail("TestFailed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen(driver)).build());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		report.flush();
		Helper.sleep();
		quitDriver();
	}

}

