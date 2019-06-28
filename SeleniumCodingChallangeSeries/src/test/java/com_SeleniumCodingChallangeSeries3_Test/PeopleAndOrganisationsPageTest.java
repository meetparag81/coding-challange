package com_SeleniumCodingChallangeSeries3_Test;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com_SeleniumCodingChallange3_Pages.PeopleAndOrganisationsPage;
import com_SeleniumCodingChallange_TestBase.TestBase;



public class PeopleAndOrganisationsPageTest extends TestBase
{ PeopleAndOrganisationsPage PAOP;
	PeopleAndOrganisationsPageTest()
	{
		super();
	}
	
	
	
	@DataProvider
	public  Iterator<Object[]> getTestData(ITestContext c)
	{
	ArrayList<Object[]>	PeopleAndOrganisation= PAOP.getdatafromExcel();	
	return PeopleAndOrganisation.iterator();
	}

}
