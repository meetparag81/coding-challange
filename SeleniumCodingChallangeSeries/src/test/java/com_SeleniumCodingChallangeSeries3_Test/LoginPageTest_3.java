package com_SeleniumCodingChallangeSeries3_Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_SeleniumCodingChallange3_Pages.LoginPage_3;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class LoginPageTest_3 extends TestBase
{
	LoginPage_3 LoginPage;
	
	LoginPageTest_3()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		TestBase.InatilizeBrowser();
		LoginPage= new LoginPage_3();
	}
	@ Test
	public void EnterValidUserNameTest()
	{
		
	}

}
