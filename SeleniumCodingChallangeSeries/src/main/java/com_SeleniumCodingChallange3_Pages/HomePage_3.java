package com_SeleniumCodingChallange3_Pages;

import org.openqa.selenium.support.PageFactory;

import com_SeleniumCodingChallange_TestBase.TestBase;

public class HomePage_3 extends TestBase
{
	private String msg;

	public HomePage_3()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String GetUserName()
	{
		return msg;
		
	}

}
