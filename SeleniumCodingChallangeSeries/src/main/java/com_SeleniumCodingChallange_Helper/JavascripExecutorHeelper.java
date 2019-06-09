package com_SeleniumCodingChallange_Helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com_SeleniumCodingChallange_TestBase.TestBase;


public class JavascripExecutorHeelper extends TestBase 
{
	
	Logger log = Logger.getLogger(JavascripExecutorHeelper.class);
	public static  Object executeScript(String script) 
	{
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);

	}
}
