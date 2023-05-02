package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Name: DriverScript
 * Description: Manages the driver and browsers related configuration
 * Developed By: Shantosh
 * Reviewed By: Aarthi
 * Date Reviewd : 04-26-2023
 */

public class DriverScript {
	
	public static WebDriver driver;
	Properties prop;
	
	/*
	 * constructor is responsible for getting the details from the properties file
	 */
	public DriverScript() {
		try
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to load config.properties file please check "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	 * initapplication will get the browser details from the properties file and lauch the application
	 */
	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println(browser+ " : in use");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println(browser+ " : in use");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.out.println(browser+ " : in use");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println(browser+ " is not supported browser please check config.properties file");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		lauchURL();
	}
	
	/*
	 * load the url from the properties file and pass this method to initapplication above
	 */
	public void lauchURL()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	/*
	 * quit the driver
	 */
	public void quitDriver()
	{
		driver.quit();
	}

}











