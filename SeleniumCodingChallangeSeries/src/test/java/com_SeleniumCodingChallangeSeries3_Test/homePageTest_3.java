package com_SeleniumCodingChallangeSeries3_Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_SeleniumCodingChallange3_Pages.HomePage_3;
import com_SeleniumCodingChallange3_Pages.LoginPage_3;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class homePageTest_3 extends TestBase
{
	private LoginPage_3 LoginPage;
	private HomePage_3 HomePage;
	public homePageTest_3()
	{
		super();

	}
	@BeforeMethod
	public void SetUp()
	{
		TestBase.InatilizeBrowser();
		LoginPage= new LoginPage_3();
	}
	
	@Test
	public void AddPeopleTest()
	{
		HomePage.AddPeople();
		
	}

}
