package com_SeleniumCodingChallange3_Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_SeleniumCodingChallangeSeries2_Test.DepartureRoundTest;
import com_SeleniumCodingChallange_Helper.Exls_ReaderHelper;
import com_SeleniumCodingChallange_Helper.LoggerHelper;
import com_SeleniumCodingChallange_Helper.ResourceHelper;
import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class LoginPage_3 extends TestBase 
{
	public static Logger log = LoggerHelper.getLogger(LoginPage_3.class);
	static Exls_ReaderHelper reader = new Exls_ReaderHelper(ResourceHelper.getResourcePath("\\src\\main\\java\\SeleniumCodingChallange_TestData\\SeleniumCodingChallangeSeries_2.xlsx"));
private String msg;


@FindBy(xpath="//label[contains (text(), 'Username')]//following::input[1]")WebElement Username;
@FindBy(xpath="//label[contains (text(), 'Password')]//following::input[1]")WebElement Password;
@FindBy(xpath="//label[contains (text(), 'Password')]//following::input[2]")WebElement LoginButton;

	public LoginPage_3()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void EnterValidUsername(String Username) 
	{
		this.Username.sendKeys(Username);
		
	}
	
	public void EnterValidPassword(String Password)
	{
		this.Password.sendKeys(Password);
	}
	
	public void ClickOnLoginButton()
	{
		TestUtil.ClickJavascriptExecutor(LoginButton, driver);
		
	}
	 
	
	public   HomePage_3 LoinWithValidCredentials()
	{
		String username= reader.getCellData("LoginPage_3", "UserName", 1);
		EnterValidUsername(username);
		String password= reader.getCellData("LoginPage_3", "Password", 1);
		EnterValidPassword(password);
		ClickOnLoginButton();
		log.info("Clicked on Login Button");
		return new HomePage_3();
		
	}
	
	
		
	}
	


