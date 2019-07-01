package com_SeleniumCodingChallangeSeries3_Test;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_SeleniumCodingChallange2_Pages.HomePagePage;
import com_SeleniumCodingChallange3_Pages.HomePage_3;
import com_SeleniumCodingChallange3_Pages.LoginPage_3;
import com_SeleniumCodingChallange3_Pages.PeopleAndOrganisationsPage;
import com_SeleniumCodingChallange_TestBase.TestBase;



public class PeopleAndOrganisationsPageTest extends TestBase
{ 
	private PeopleAndOrganisationsPage PAOP;
 private LoginPage_3 LoginPage;
private HomePage_3 HomePage;

	PeopleAndOrganisationsPageTest()
	{
		super();
	}
	
		
	@BeforeTest
	public void SetUp()
	{
	TestBase.InatilizeBrowser();
	LoginPage = new LoginPage_3();
	HomePage=LoginPage.LoginithValidCredentials();
	PAOP=HomePage.ClickOnAddPeople();
	}
	
	
	@Test(priority=1,groups = {"functional" },dataProvider= "getTestData",enabled= true)
	public void VlueTest(String Title, String F‌irstNa‌me,String L‌astNa‌me,String J‌obTi‌tle, String O‌rganisation, String T‌ags,String PhoneNumbers, String Ph‌oneNu‌mbersType,String Em‌ailAd‌dresses, String Em‌ailAd‌dressesType, String We‌bsites,String We‌bsitesType,String Ad‌dresses, String Ad‌dressesType,String State,String City,String Zipcode)
	{
		
		PAOP.AddPeopleDetails(Title, F‌irstNa‌me, L‌astNa‌me, J‌obTi‌tle, O‌rganisation, T‌ags, Ph‌oneNu‌mbersType, PhoneNumbers, Em‌ailAd‌dresses, Em‌ailAd‌dressesType, We‌bsites, We‌bsitesType, Ad‌dresses, Ad‌dressesType, City, State, Zipcode);
		
	}
	
	@DataProvider
	public  Iterator<Object[]> getTestData(ITestContext c)
	{
	ArrayList<Object[]>	PeopleAndOrganisation= PAOP.getdatafromExcel();	
	return PeopleAndOrganisation.iterator();
	}

}

	
	
	


