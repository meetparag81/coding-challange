package com_SeleniumCodingChallange3_Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_SeleniumCodingChallange_Helper.Exls_ReaderHelper;
import com_SeleniumCodingChallange_Helper.LoggerHelper;
import com_SeleniumCodingChallange_Helper.ResourceHelper;
import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class LoginPage_3 extends TestBase
{
	public static Logger log = LoggerHelper.getLogger(LoginPage_3.class);
	public static Exls_ReaderHelper reader = new Exls_ReaderHelper(ResourceHelper.getResourcePath("\\src\\main\\java\\SeleniumCodingChallange_TestData\\SeleniumCodingChallangeSeries_2.xlsx"));
	@FindBy(xpath="//label[contains (text() , 'Password')]//preceding::input[1]" )WebElement UserName;
	@FindBy(xpath="//label[contains (text() , 'Password')]//following::input[1]")WebElement Password;
	@FindBy(xpath="//label[contains (text() , 'Password')]//following::input[2]")WebElement LoginButton;
	public LoginPage_3()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterValidUserName(String UserName)
	{
		this.UserName.sendKeys(UserName);
		
	}
	
	public void EnterValidPassword(String Password)
	{
		this.Password.sendKeys(Password);
		
	}
	
	public void ClickOnLoginButton()
	{
		TestUtil.ClickUsingJavascript(LoginButton, driver);
			
	}
	
	public HomePage_3 LoginithValidCredentials()
	{
		String username= reader.getCellData("LoginPage_3", "UserName", 2);
		EnterValidUserName(username);
		String password= reader.getCellData("LoginPage_3", "Password", 2);
		EnterValidPassword(password);
		ClickOnLoginButton();
		return new HomePage_3();
		
	}
	
	


}
