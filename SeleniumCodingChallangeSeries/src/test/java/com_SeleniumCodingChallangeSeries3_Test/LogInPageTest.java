package com_SeleniumCodingChallangeSeries3_Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_SeleniumCodingChallange3_Pages.HomePage_3;
import com_SeleniumCodingChallange3_Pages.LoginPage_3;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class LogInPageTest extends TestBase
{
	LoginPage_3 LogInPage;
	 HomePage_3 HomePage;
	LogInPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void SetUp()
	{
		
		TestBase.InatilizeBrowser();
		LogInPage = new LoginPage_3();
	}
	
	@Test
	public void LoginwithValidCredentialsTest()
	{
		HomePage= LogInPage.LoinWithValidCredentials();
	}
	
	

}
