package com_SeleniumCodingChallange3_Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com_SeleniumCodingChallange_Helper.LoggerHelper;
import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class HomePage_3 extends TestBase
{
	public static Logger log = LoggerHelper.getLogger(HomePage_3.class);
	private String msg;
	@FindBy(xpath="//span[contains  (text() , 'Parag')]")WebElement UserNameText;

	public HomePage_3()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String GetUserName()
	{
		try
		{
			TestUtil.VisibleOn(driver, UserNameText, 30);
		}
		catch(TimeoutException e)
		{
			log.info(e.getStackTrace());
		}
		boolean flag=false;
		if(UserNameText.isDisplayed());
		{
			 flag = true;
		}
		flag= false;
		if(flag=false)
		{
			return null;
		}
		return msg=UserNameText.getText();
		
	}

}
