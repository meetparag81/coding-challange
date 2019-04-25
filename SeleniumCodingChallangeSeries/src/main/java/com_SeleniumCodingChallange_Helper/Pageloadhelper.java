package com_SeleniumCodingChallange_Helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_SeleniumCodingChallange_TestBase.TestBase;

public class Pageloadhelper extends TestBase 
{
	public static boolean waitForJSandJQueryToLoad() 
	{
		System.out.println();
	    WebDriverWait wait = new WebDriverWait(driver, 30);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() 
	    {
	      public Boolean apply( WebDriver driver) 
	      {
	        try 
	        {
	          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) 
	        {
	          // no jQuery present
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() 
	    {
	      public Boolean apply(WebDriver driver) 
	      {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
	      }
	    };
		return false;

}

}
