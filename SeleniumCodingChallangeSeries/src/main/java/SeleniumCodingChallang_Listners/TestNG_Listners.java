package SeleniumCodingChallang_Listners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import com_SeleniumCodingChallangeSeries2_Test.DepartureRoundTest;
import com_SeleniumCodingChallange_Helper.LoggerHelper;
import com_SeleniumCodingChallange_Helper.ScreenshotHelper;
import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;


public class TestNG_Listners extends TestBase  implements ITestListener, WebDriverEventListener 
{

	public static Logger log = LoggerHelper.getLogger(TestNG_Listners.class);

	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		if(TestResult.FAILURE==result.getStatus())
		{
			try {
				ScreenshotHelper.getScreenshotForFailTestcase(driver, result.getName());
			} catch (Exception e) 
			{
				
				log.info(e.getStackTrace());
			}
		}
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		if(TestResult.SKIP==result.getStatus())
		{
			try {
				ScreenshotHelper.getScreenshotForSkipTestcase(driver, result.getName());
			} catch (Exception e) 
			{
				
				log.info(e.getStackTrace());
			}
		}
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) 
	{
		if(arg0.isEnabled()==false )
		{
			ScreenshotHelper.getScreenshotForPasstest(driver, arg1.getTitle());
		}
		
		
		
	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
