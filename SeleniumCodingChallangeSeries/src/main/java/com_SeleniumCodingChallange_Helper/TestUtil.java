package com_SeleniumCodingChallange_Helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_SeleniumCodingChallange_TestBase.TestBase;

public class TestUtil extends TestBase
{
	public static  long PAGE_LOAD_TIMEOUT = 10;
	public static  long IMPLICIT_WAIT  = 30;
	
	
	public static void ClickOn(WebDriver driver,WebElement locator,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeSelected(locator));
		locator.click();
		
	}
	public static void  VisibleOn(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void  VisibleElementsOn(WebDriver driver,List<WebElement> element,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public static void ScrollthePage(JavascriptExecutor js,WebDriver driver)
	{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("scroll(0, 250);");
		
	}
	
	
	
	public static void takeScreenshotAtEndOfTest1()
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try 
		{
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots1/" + System.currentTimeMillis() + ".png"));
		}
		catch (IOException e) 
		{
			System.out.println("Exception are" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void takescreenshot(WebDriver driver, String screenshotname)  
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try 
		{
			FileUtils.copyFile(source, new File(currentDir + "/screenshots"+ screenshotname +".png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Exception are" + e.getMessage());
			e.printStackTrace();
		}	

	}
	public static  Actions ActionForMovetoElement(WebElement element )
	{
		
		Actions act1 = new Actions(driver);
		return act1.moveToElement(element);
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception 
		{
	        //below line is just to append the date format with the screenshot name to avoid duplicate names 
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    formatter = new SimpleDateFormat("dd,MM,yyyy"); 
	    String dateName = new SimpleDateFormat("dd,MM,yyyy").format(new Date());
	   //     String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	        //Returns the captured file path
	return destination;
		}
	public static String getMonthForInt(int num) 
	{
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();      
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) 
        {
            month = months[num];
        }
        return month;	
		
	}
	public static String Date()
	{
		Date date1 = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
	    formatter = new SimpleDateFormat("dd,MMM,yyyy"); 
	    String strDate = formatter.format(date1);  
		strDate = formatter.format(date1); 
		
		
		return strDate;
		
	}
	public static String DateForCompare()
	{
		Date date1 = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
	    String strDate = formatter.format(date1);  
		strDate = formatter.format(date1); 
		
		
		return strDate;
		
	}
	public static String Incrementeddate(int a)
	{
	System.out.println();
	String month= TestUtil.getMonthForInt(4);
	Date date = new Date(); 
	Calendar cal1 = Calendar.getInstance();
	cal1.setTime(date);
	cal1.add(Calendar.DATE, a); 
	date = cal1.getTime();
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
    String strDate = formatter.format(date);  
	@SuppressWarnings("unused")
	String arrdate = formatter.format(date); 
	
	
	return arrdate ;
	}
	
	public static void IntDate()
	{
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
	}
	public static String CurrentDate()
	{
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
	    String strDate = formatter.format(date);  
		return strDate;  
	}
	public static void ActionForMovetoElementSelect(Select select, WebElement element) 
	{
		Select select1 = new Select(element);
		Actions act1 = new Actions(driver);
		act1.moveToElement((WebElement) select1);
		
		
	}
	

}
