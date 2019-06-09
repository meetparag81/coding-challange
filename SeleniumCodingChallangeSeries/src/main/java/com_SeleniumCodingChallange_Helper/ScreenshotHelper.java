package com_SeleniumCodingChallange_Helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.model.Log;



public class ScreenshotHelper 
{
	
	
	
	
	public static String getScreenshotForFailTestcase(WebDriver driver, String screenshotName) throws Exception 
	{
        //below line is just to append the date format with the screenshot name to avoid duplicate names 
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    formatter = new SimpleDateFormat("dd,MM,yyyy"); 
    String dateName = new SimpleDateFormat("dd,MM,yyyy").format(new Date());
   //     String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
String destination =ResourceHelper.getResourcePath( "/FailedTestsScreenshots/"+screenshotName+dateName+".png");
File finalDestination = new File(destination);
FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
return destination;
	}
	
	public static String getScreenshotForSkipTestcase(WebDriver driver, String screenshotName) throws Exception 
	{
        //below line is just to append the date format with the screenshot name to avoid duplicate names 
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    formatter = new SimpleDateFormat("dd,MM,yyyy"); 
    String dateName = new SimpleDateFormat("dd,MM,yyyy").format(new Date());
   //     String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
String destination =ResourceHelper.getResourcePath( "/PassedTestsScreenshots/"+screenshotName+dateName+".png");
File finalDestination = new File(destination);
FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
return destination;
	}

	public static String getScreenshotForPasstest(WebDriver driver, String screenshotName) 
	{
	     //below line is just to append the date format with the screenshot name to avoid duplicate names 
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    formatter = new SimpleDateFormat("dd,MM,yyyy"); 
	    String dateName = new SimpleDateFormat("dd,MM,yyyy").format(new Date());
	   //     String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	        
	//after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination =ResourceHelper.getResourcePath( "/SkipedTestsScreenshots/"+screenshotName+dateName+".png");
	File finalDestination = new File(destination);
	try {
		FileUtils.copyFile(source, finalDestination);
	} catch (IOException e) 
	{
		
	e.getStackTrace();
	}
	        //Returns the captured file path
	return destination;
		
		
	}

}
