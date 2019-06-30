package com_SeleniumCodingChallangeSeries3_Test;

import org.testng.annotations.BeforeMethod;

import com_SeleniumCodingChallange3_Pages.LoginPage_3;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class PeopleAndOrganisationsPageTest extends TestBase 
{
	private LoginPage_3 LoginPage;

	public PeopleAndOrganisationsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		TestBase.InatilizeBrowser();
		LoginPage = new LoginPage_3();
	}

}
