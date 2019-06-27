package com_SeleniumCodingChallange_TestBase;

//sysout
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Listeners;

import SeleniumCodingChallang_2_Listners.TestNG_Listners;
import com_SeleniumCodingChallange_Helper.Pageloadhelper;
import com_SeleniumCodingChallange_Helper.LoggerHelper;
import com_SeleniumCodingChallange_Helper.ResourceHelper;
import com_SeleniumCodingChallange_Helper.TestUtil;

@Listeners(TestNG_Listners.class)
public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LoggerHelper.getLogger(TestBase.class);
	private static String msg;

	public TestBase() 
	{
		prop = new Properties();
		FileInputStream ip;
		try {
			prop = new Properties();
			log.info("property file initalized");
			ip = new FileInputStream(ResourceHelper.getResourcePath("\\src\\main\\resources\\config3.properties"));

			try {
				prop.load(ip);
			} catch (IOException e) {

				log.info("I/O Exception seen.");
			}
		} catch (FileNotFoundException e) {

			log.info(" File not find Exception seen.");
		}

	}

	public static String initalization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					ResourceHelper.getResourcePath("\\src\\main\\resources\\geckodriver.exe"));
			driver = new FirefoxDriver();
		} else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("\\src\\main\\resources\\chromedriver.exe"));
			driver = new ChromeDriver();

			System.setProperty("webdriver.chrome.verboseLogging", "true");

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Pageloadhelper.waitForJSandJQueryToLoad();
		try {
			String URL = prop.getProperty("url");
			driver.get(URL);
			log.info("url is entered");
			String title = driver.getTitle();
			System.out.println("Title is " + "=" + title);
			if (!title.equals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday")) 
			{
				return msg = "false";
			} 
			else 
			{
				return msg = "true";
			}
		} 
		catch (  Exception e) 
		{
			log.info("url is entered but InterruptedException is seen");
			return msg = "false";

		}
	}

	public static void InatilizeBrowser() 
	{
		String msg = initalization();

		
		 if(msg.equals("false")) { try
		  {
		  
		  driver.get(prop.getProperty("url")); } catch(Exception e) { try 
		  {
		   Thread.sleep(2000); 
		  } 
		 catch (InterruptedException e2) 
		  {
			 
		  }
		  }
		  log.info("url is not entered"); 
		  try
		  {
		  driver.get(prop.getProperty("url")); 
		  } 
		  catch(TimeoutException e1) 
		  {
		  e1.getMessage(); 
		  }
	
	}
}
}
