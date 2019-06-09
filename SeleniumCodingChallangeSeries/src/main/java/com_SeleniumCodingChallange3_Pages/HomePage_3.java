package com_SeleniumCodingChallange3_Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class HomePage_3 extends TestBase
{
	@FindBy(xpath="//span[text()='Parag B']")WebElement HomePageText;
	private String msg;
	
	public HomePage_3()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String ValidateHomePage()
	{
		try
		{
		TestUtil.VisibleOn(driver, HomePageText, 30);
		}
		catch(TimeoutException e)
		{
			log.info("HomePageText element not seen with in 30 sec");
		}
	return msg= HomePageText.getText();

}
	
}
