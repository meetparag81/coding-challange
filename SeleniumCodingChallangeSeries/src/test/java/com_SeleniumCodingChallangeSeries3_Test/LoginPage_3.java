package com_SeleniumCodingChallangeSeries3_Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_SeleniumCodingChallange_TestBase.TestBase;

public class LoginPage_3 extends TestBase
{
	@FindBy(xpath= )WebElement UserName;
	
	LoginPage_3()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterValidUserName(String UserName)
	{
		
	}

}
