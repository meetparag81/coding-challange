package com_SeleniumCodingChallange2_Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class HomePagePage extends TestBase {

	@FindBy(xpath = "//div[@class='fsw_inner ']/div[1]")WebElement From;
	@FindBy(xpath = "//span[text()='From']//following::input[2]")WebElement FromInput;
	@FindBy(xpath = "//div[@class='fsw_inner ']/div[2]")WebElement TO;
	@FindBy(xpath = "//span[text()='To']//following::input[2]")WebElement ToInput;
	@FindBy(xpath = "//ul[@class='fswTabs latoBlack greyText']/li[2]/span")WebElement RoundTrip;
	@FindBy(xpath="//ul[@class='makeFlex font12']/li[1]/a")WebElement Flights;
	@FindBy(xpath="//div[@class='description']")WebElement popup;
	@FindBy(xpath="//button[@id='deny']")WebElement Deny;
	@FindBy(xpath="//div[@class='fsw_inner ']/div[3]")WebElement Departuredate;
	@FindBy(xpath="//div[@class='fsw_inner ']/div[3]")WebElement ArrivalDate;	
	@FindAll({ @FindBy(xpath = "//ul[@class='react-autosuggest__suggestions-list']/li") })List<WebElement> PicupList;
	@FindBy (xpath="//ul[@class='react-autosuggest__suggestions-list']/li//div//p[text()='Delhi, India']//parent::div//parent::div//parent::li")WebElement Pickup;
	@FindAll({ @FindBy(xpath = "//ul[@class='react-autosuggest__suggestions-list']/li") })List<WebElement> DesitinationList;
	@FindBy(xpath="//ul[@class='react-autosuggest__suggestions-list']/li//div//p[text()='Bangalore, India']//parent::div//parent::div//parent::li")WebElement Destination;
	@FindAll({ @FindBy(xpath = "(//div[@class='DayPicker-Body'])[1]/div/div") })List<WebElement> Departuredates;
	

	public HomePagePage() 
	{
		PageFactory.initElements(driver, this);
	}

	public boolean Roundtrip() 
	{
		try {
			TestUtil.VisibleOn(driver, RoundTrip, 30);
		} catch (TimeoutException e) {
			log.info("RoundTrip element is not seen with in 30 sec");
		}

		boolean falg = true;
		if (RoundTrip.isSelected() == true) 
		{

			return falg = true;

		} else {
			falg = false;
		}
		return falg;

	}

	public void ClickOnRoundTrip() 
	{
		boolean flag = Roundtrip();
		if (flag == true) {

		} else 
		{
			TestUtil.ActionForMovetoElement(RoundTrip).click().build();

		}

	}

	public void SelectPickupLocation() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, From, 30);
		} 
		catch (TimeoutException e)
		{
			log.info(e.getMessage());

		}
		TestUtil.ActionForMovetoElement(From).click().build().perform();
		FromInput.click();
		FromInput.sendKeys("Delhi");
		TestUtil.ActionForMovetoElement(Pickup).click().doubleClick().build().perform();
		/*for (int i = 0; i < PicupList.size(); i++) 
		{
			if (PicupList.get(i).getText().equals("Delhi, India")) 
			{
				PicupList.get(i).click();
				break;

			}*/
		}

	

	public void SelectDestinationLocation() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, TO, 30);
		} catch (TimeoutException e) 
		{
			log.info(e.getMessage());

		}
		TestUtil.ActionForMovetoElement(TO).click().build().perform();
		ToInput.clear();
		ToInput.sendKeys("Bangalore");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtil.ActionForMovetoElement(Destination).click().build().perform();
		/*for (int j = 0; j < DesitinationList.size(); j++)
		{
			if (DesitinationList.get(j).getText().equals("Bangalore, India")) 
			{
				DesitinationList.get(j).click();
				break;

			}
*/
		}

	
	
	public boolean SelectConditionFlights() 
	{
		try {
			TestUtil.VisibleOn(driver, Flights, 30);
			}
			catch (TimeoutException e) 
			{
				log.info("Flights element is not seen with in 30 sec");
			}

		boolean falg = true;
		if (Flights.isSelected() == true) 
		{

			return falg = true;

		} else {
			falg = false;
		}
		return falg;

	}
	public void ClickOnFlights() 
	{
		boolean flag = SelectConditionFlights();
		if (flag == true) 
		{

		} else 
		{
			TestUtil.ActionForMovetoElement(Flights).click().build().perform();

		}

	}
	
	public boolean Popupdisplay()
	{
		return false;
		
	}
	
	@SuppressWarnings("unused")
	public void SelectDeparturedate()
	{
		try
		{
		TestUtil.VisibleOn(driver, Departuredate, 30);
		}
		catch(TimeoutException e)
		{
			log.info("Element- Departuredate is not seen with in 30 sec");
		}
		TestUtil.ActionForMovetoElement(Departuredate).click().build().perform();
		String todaysdate= TestUtil.Date();
		@SuppressWarnings("unused")
		String[] Date= todaysdate.split(",");
		String Day = Date[0];
		 @SuppressWarnings("unused")
		String Month = Date[1];
		String Year = Date[2];
		System.out.println();
		int size= Departuredates.size();
		int count=0;
		for(int i=1;i<size;i++)
		{
			count++;
			
			WebElement element = Departuredates.get(i);
			String elementname = Departuredates.get(i).getText();
			String Dates[] = elementname.split(" "); 
			String Dayincal = Dates[0];
			if(count==26)
			{
				log.info("datetext is matched");
				if(element.isDisplayed()&&element.isEnabled()&&!element.isSelected())
				{
				TestUtil.ActionForMovetoElement(Departuredates.get(i)).doubleClick().build().perform();
					break;
				}
			}
				
				
				
			}
		}
	
	public String[] GetArrivalDate()
	{
		String Date = TestUtil.Incrementeddate(7);
		String []date1= Date.split("-");
		return date1;
	
	}
	
	public void SetArrivalDate()
	{
		String[] arrdate=GetArrivalDate();
		String arrday = arrdate[0]; 
		String arrMonth = arrdate[1]; 
		String arryear = arrdate[2];
		
		
		
	}
	
	
	
	
	}
	
	

