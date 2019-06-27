package com_SeleniumCodingChallangeSeries3_Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com_SeleniumCodingChallange3_Pages.HomePage_3;
import com_SeleniumCodingChallange3_Pages.LoginPage_3;
import com_SeleniumCodingChallange3_Pages.PeopleAndOrganisationsPage;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class homePageTest_3 extends TestBase
{
	private LoginPage_3 LoginPage;
	private HomePage_3 HomePage;
	private PeopleAndOrganisationsPage PeopleAndOrganisationsPage;
	public homePageTest_3()
	{
		super();

	}
	@BeforeMethod
	public void SetUp()
	{
		TestBase.InatilizeBrowser();
		LoginPage= new LoginPage_3();
	HomePage=LoginPage.LoginithValidCredentials();
	}
	
	@Test
	public void AddPeopleTest()
	{
		PeopleAndOrganisationsPage=HomePage.ClickOnAddPeople();
		String Act = PeopleAndOrganisationsPage.PeopleAndOrganisationsPageText();
		String Exp="People & Organisations";
		Assert.assertEquals(Act, Exp);
		log.info("Click on Add PeopleTest is completed");
		
	}

}
