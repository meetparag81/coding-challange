package com_SeleniumCodingChallangeSeries2_Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_SeleniumCodingChallange2_Pages.HomePagePage;
import com_SeleniumCodingChallange_Helper.LoggerHelper;
import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class DepartureRoundTest extends TestBase 
{
	public static Logger log = LoggerHelper.getLogger(DepartureRoundTest.class);
	
	HomePagePage HomePage;
	
	public DepartureRoundTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		TestBase.InatilizeBrowser();
		HomePage = new HomePagePage();
		HomePage.ClickOnFlights();
		HomePage.ClickOnRoundTrip();
	}
	
	@Test
	public void NumberOfDepartureFlights()
	{
		HomePage.SelectPickupLocation();
		log.info("Pickuplocation added");
		HomePage.SelectDestinationLocation();
		log.info("Destination location added");
		HomePage.SelectDeparturedate();
		
		HomePage.SetArrivalDate();
		log.info("Departure date added");
		String Act= HomePage.ClickOnSearch();
		String Exp = "Makemytrip";
		if(Act.equals(Exp))
		{
			boolean flag= true;
		int actual= HomePage.NoofDepartureFlights();
		int expected = 42;
		Assert.assertEquals(actual, expected, "Departureflights are not matching");
		}
		else
		{
			boolean flag = false;
			Assert.assertTrue(flag);
			}
		
		
		
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
		log.info("browser is closed");
	}

}
