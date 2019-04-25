package com_SeleniumCodingChallange_TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Listeners;

import com_SeleniumCodingChallange_Helper.LoggerHelper;
import com_SeleniumCodingChallange_Helper.ResourceHelper;
import com_SeleniumCodingChallange_Helper.TestUtil;
@Listeners()
public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LoggerHelper.getLogger(TestBase.class);
	
	
	
	public TestBase()
	{
		prop = new Properties();
		FileInputStream ip;
		try
		{
			prop = new Properties();
			log.info("property file initalized");
			 ip = new FileInputStream(ResourceHelper.getResourcePath("\\src\\main\\resources\\config.properties"));
			
			try 
			{
				prop.load(ip);
			}
			catch (IOException e) 
			{
				
				log.info("I/O Exception seen.");
			}
		}
		catch (FileNotFoundException e) 
		{
			
			log.info(" File not find Exception seen.");
		}
		
		
		
		
	}
	
	public static void initalization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",ResourceHelper.getResourcePath("\\src\\main\\resources\\geckodriver.exe"));
			driver = new FirefoxDriver();		
		}	
		else if(browsername.equals("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver" ,ResourceHelper.getResourcePath("\\src\\main\\resources\\chromedriver.exe"));
			driver = new ChromeDriver();
			
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			
		 }
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		try
		{
		driver.get(prop.getProperty("url"));
		}
		catch(Exception e)
		{
			System.out.println("url is not entered");
			
		}
		
	}
	
	

}
