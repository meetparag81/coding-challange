package com_SeleniumCodingChallange2_Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.bouncycastle.crypto.KeyEncapsulation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com_SeleniumCodingChallange_Helper.Exls_ReaderHelper;
import com_SeleniumCodingChallange_Helper.LoggerHelper;
import com_SeleniumCodingChallange_Helper.ResourceHelper;
import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class HomePagePage extends TestBase 
{
	public static Logger log = LoggerHelper.getLogger(HomePagePage.class);
	
	@FindBy(xpath = "//div[@class='fsw_inner ']/div[1]")WebElement From;
	@FindBy(xpath = "//span[text()='From']//following::input[2]")WebElement FromInput;
	@FindBy(xpath = "//div[@class='fsw_inner ']/div[2]")WebElement TO;
	@FindBy(xpath = "//span[text()='To']//following::input[2]")WebElement ToInput;
	@FindBy(xpath = "//ul[@class='fswTabs latoBlack greyText']/li[2]/span")WebElement RoundTrip;
	@FindBy(xpath="//ul[@class='makeFlex font12']/li[1]/a")WebElement Flights;
	@FindBy(xpath="//div[@class='description']")WebElement popup;
	@FindBy(xpath="//button[@id='deny']")WebElement Deny;
	@FindBy(xpath="//div[@class='fsw_inner ']/div[3]")WebElement Departuredate;
	@FindBy(xpath="//div[@class='fsw_inner ']/div[4]")WebElement ArrivalDate;
	@FindBy(xpath="//div[@class='DayPicker-Month']//div/div")WebElement Monthele;
	@FindBy(xpath="//div[@class='DayPicker-NavBar']/span[1]") WebElement PrevMontharrow;
	@FindAll({ @FindBy(xpath = "//ul[@class='react-autosuggest__suggestions-list']/li") })List<WebElement> PicupList;
	@FindBy (xpath="//ul[@class='react-autosuggest__suggestions-list']/li//div//p[text()='Delhi, India']//parent::div//parent::div//parent::li")WebElement Pickup;
	@FindAll({ @FindBy(xpath = "//ul[@class='react-autosuggest__suggestions-list']/li") })List<WebElement> DesitinationList;
	@FindBy(xpath="//ul[@class='react-autosuggest__suggestions-list']/li//div//p[text()='Bangalore, India']//parent::div//parent::div//parent::li")WebElement Destination;
	@FindAll({ @FindBy(xpath = "(//div[@class='DayPicker-Body'])[1]/div/div/div/p[1]") })List<WebElement> Departuredatestext;
	@FindAll({ @FindBy(xpath = "(//div[@class='DayPicker-Body'])[1]/div//following::div/div/p[1]") })List<WebElement> Departuredates;
	@FindAll({@FindBy(xpath="(//div[@class='DayPicker-Body'])[2]/div/div/div/p[1]")})List<WebElement> ArrivalDates;
	@FindBy(xpath="(//div[@class='DayPicker-Body'])[1]/div//following::div[@class='DayPicker-Day DayPicker-Day--today']")WebElement daytoday;
	@FindAll({@FindBy(xpath="//div[@class='fli-list-body-section clearfix']")})List<WebElement> DepartureFlights;
	@FindBy(xpath="//main[@class='landingContainer']//preceding::a[text()='Search']")WebElement Search;
	private int date;
	private int todayday; 
	private int arrday;

	private String msg;
	
	static Exls_ReaderHelper reader = new Exls_ReaderHelper(ResourceHelper.getResourcePath("\\src\\main\\java\\SeleniumCodingChallange_TestData\\SeleniumCodingChallangeSeries_2.xlsx"));

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
		TestUtil.ActionForMovetoElement(Pickup).click().click().build().perform();
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
		for (int j = 1; j < DesitinationList.size(); j++)
		{
			if (DesitinationList.get(j).getText().equals("Bangalore, India")) 
			{
				DesitinationList.get(j).click();
				break;
			}
		}

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
		try
		 {
			 todayday= Integer.parseInt(Day);
		 }
		 catch(NumberFormatException e)
		 {
			 log.info(e.getStackTrace());
		 }
		 @SuppressWarnings("unused")
		String Month = Date[1];
		String Year = Date[2];
		
		String CalenderMnth= Monthele.getText();
		String[] month1= CalenderMnth.split(" ");
		String month2 = month1[0];
		 if(Month.equals(month2))
		 {
			 
		 }
		 else
		 {
			 TestUtil.ActionForMovetoElement(PrevMontharrow).click().build().perform();
		 }
		
		int size= Departuredates.size();
		int count=0;
		for(int i=0;i<size;i++)
		{
			count++;
			
			boolean flag;
			WebElement element = Departuredates.get(i);
			flag=element.isEnabled();
			flag=element.isDisplayed();
			flag=element.isSelected();
			String elementname = Departuredatestext.get(i).getText();
			
			try
			{
				date= Integer.parseInt(elementname);
			}
			catch(NumberFormatException e)
			{
				log.info("Numberformat exception seen");
			}
			
			if(daytoday.isDisplayed()==true&& daytoday.isEnabled()==true && daytoday.isSelected()==false)
			{
				TestUtil.ActionForMovetoElement(daytoday).click().build().perform();
				break;
			}
		}
			
			/*if(date==count)
			{
				log.info("datetext is matched");
				
				
				if(Departuredates.get(i).isDisplayed()&&Departuredates.get(i).isEnabled()&&!Departuredates.get(i).isSelected())
				{
				TestUtil.ActionForMovetoElement(Departuredates.get(i)).doubleClick().build().perform();
					break;
				}
			}
				
				
				
			}*/
		
		}
	
	public String[] GetArrivalDate()
	{
		String Date = TestUtil.Incrementeddate(7);
		String []date1= Date.split("-");
		return date1;
	
	}
	
	public void SetArrivalDate()
	{
		try
		{
		TestUtil.VisibleOn(driver, ArrivalDate, 30);
		}
		catch(TimeoutException e)
		{
			log.info("Element- ArrivalDate is not seen with in 30 sec");
		}
		TestUtil.ActionForMovetoElement(ArrivalDate).click().build().perform();
		String[] arrdate=GetArrivalDate();
		String arrday1 = arrdate[0]; 
		String arrMonth = arrdate[1]; 
		String arryear = arrdate[2];
		try
		{
			 arrday= Integer.parseInt(arrday1);
		}
		catch(NumberFormatException e)
		{
			log.info(e.getStackTrace());
		}
		
		if(arrday<24)
		{
			for(int j=0;j<ArrivalDates.size();j++)
			{
			if(Departuredates.get(j).isDisplayed()==true&& Departuredates.get(j).isEnabled()==true && Departuredates.get(j).isSelected()==false)
					{
					
					String datetext= Departuredates.get(j).getText();
					if(arrday1.equals(Departuredates.get(j).getText()))
					{
					Departuredates.get(j).click();
					break;
					}
				
				}
				
			}
			
		}
		else
		{
			for(int j= 1;j<ArrivalDates.size();j++)
			{
				if(ArrivalDates.get(j).isDisplayed()==true&&ArrivalDates.get(j).isEnabled()==true&&ArrivalDates.get(j).isSelected()==false)
					if(arrday1.equalsIgnoreCase(ArrivalDates.get(j).getText()))
					{
						WebElement element =ArrivalDates.get(j);
						TestUtil.ActionForMovetoElement(element).click().build().perform();
						break;
					}
				
			}
			
		
		
	}
	
	
	
	
	}

	public String ClickOnSearch() 
	{
		TestUtil.VisibleOn(driver, Search, 30);
		Search.click();
		
		return msg=driver.getTitle();
		
	}

	public int NoofDepartureFlights() 
	{
		try
		{
			TestUtil.VisibleElementsOn(driver, DepartureFlights, 30);
		}
		catch(TimeoutException e)
		{
			log.info("DepartureFlightsisnotseenwithin30secs");
		}
		
		int Noofflights = DepartureFlights.size();
		return Noofflights;
		
		
	}
 }


	
	

