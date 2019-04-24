package com_SeleniumCodingChallange2_Pages;

import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_SeleniumCodingChallange_Helper.TestUtil;
import com_SeleniumCodingChallange_TestBase.TestBase;

public class HomePagePage extends TestBase {

	@FindBy(xpath = "//span[text()='From']//following::input[1]")
	WebElement From;
	@FindBy(xpath = "//span[text()='To']//following::input[1]")
	WebElement TO;
	@FindBy(xpath = "(//span[@class='tabsCircle appendRight5'])[2])")
	WebElement RoundTrip;
	@FindAll({ @FindBy(xpath = "//ul[@class='react-autosuggest__suggestions-list']/li") })
	List<WebElement> PicupList;
	@FindAll({ @FindBy(xpath = "//ul[@class='react-autosuggest__suggestions-list']/li") })
	List<WebElement> DesitinationList;

	public HomePagePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean Roundtrip() {
		try {
			TestUtil.VisibleOn(driver, RoundTrip, 30);
		} catch (TimeoutException e) {
			log.info("RoundTrip element is not seen with in 30 sec");
		}

		boolean falg = true;
		if (RoundTrip.isSelected() == true) {

			return falg = true;

		} else {
			falg = false;
		}
		return falg;

	}

	public void ClickOnRoundTrip() {
		boolean flag = Roundtrip();
		if (flag == true) {

		} else {
			TestUtil.ActionForMovetoElement(RoundTrip).click().build().perform();

		}

	}

	public void SelectPicupLocation() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, From, 30);
		} catch (TimeoutException e)
		{
			log.info(e.getMessage());

		}
		TestUtil.ActionForMovetoElement(From).click().sendKeys("Delhi");
		for (int i = 0; i < PicupList.size(); i++) {
			if (PicupList.get(i).getText().equals("Delhi, India")) 
			{
				PicupList.get(i).click();
				break;

			}
		}

	}

	public void SelectDestinationLocation() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, From, 30);
		} catch (TimeoutException e) 
		{
			log.info(e.getMessage());

		}
		TestUtil.ActionForMovetoElement(From).click().sendKeys("Banglore");
		for (int j = 0; j < PicupList.size(); j++)
		{
			if (PicupList.get(j).getText().equals("Bangalore, India")) 
			{
				PicupList.get(j).click();
				break;

			}

		}

	}
}
