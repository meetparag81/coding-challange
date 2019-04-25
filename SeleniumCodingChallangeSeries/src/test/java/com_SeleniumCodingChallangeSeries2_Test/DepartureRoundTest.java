package com_SeleniumCodingChallangeSeries2_Test;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_SeleniumCodingChallange2_Pages.HomePagePage;
import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class DepartureRoundTest extends TestBase 
{
	
	HomePagePage HomePage;
	
	public DepartureRoundTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		TestBase.initalization();
		HomePage = new HomePagePage();
		HomePage.ClickOnFlights();
		HomePage.ClickOnRoundTrip();
	}
	
	@Test
	public void NumberOfDepartureFlights()
	{
		HomePage.SelectPickupLocation();
		HomePage.SelectDestinationLocation();
		HomePage.SelectDeparturedate();
		
		
		
	}

}
