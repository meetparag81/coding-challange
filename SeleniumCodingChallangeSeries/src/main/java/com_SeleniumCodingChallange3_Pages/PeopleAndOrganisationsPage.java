package com_SeleniumCodingChallange3_Pages;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;

import com_SeleniumCodingChallange_Helper.Exls_ReaderHelper;
import com_SeleniumCodingChallange_Helper.ResourceHelper;
import com_SeleniumCodingChallange_TestBase.TestBase;
import seleniumCodingChallange_ExcelUtility.Exls_Reader;

public class PeopleAndOrganisationsPage extends TestBase 
{
	
	 public PeopleAndOrganisationsPage()
	{
		PageFactory.initElements(driver, this); 
	}

	 
	 
	 public void AddPeopleDetails(String Title,String F‌irstNa‌me,String L‌astNa‌me,String J‌obTi‌tle,String O‌rganisation,String T‌ags,String Ph‌oneNu‌mbers,String Ph‌oneNu‌mbersType,String Em‌ailAd‌dresses,String Em‌ailAd‌dressesType,String We‌bsites,String We‌bsitesType ,String Ad‌dresses,String Ad‌dressesType,String City,String State,String Zipcode )
	 {
		 
	 }
	 
	 
	 public static ArrayList<Object[]> getdatafromExcel() 
		{
		 Exls_Reader reader = null;

			ArrayList<Object[]> mydata = new ArrayList<Object[]>();
			try {
				reader = new Exls_Reader(ResourceHelper.getResourcePath("\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx"));
			} catch (Exception e) 
			{
				e.printStackTrace();
			}

			int count1 = reader.getRowCount("Addictions");
			for (int rows = 2; rows <= count1; rows++) {

				String Addiction = reader.getCellData("Addictions", 0, rows);
				String CurrentStatus = reader.getCellData("Addictions", 1, rows);
				String SinceWhenM = reader.getCellData("Addictions", 2, rows);
				String SinceWhenY = reader.getCellData("Addictions", 3, rows);
				String Frequency = reader.getCellData("Addictions", 4, rows);
				String Quantity = reader.getCellData("Addictions", 5, rows);

				Object[] obj = { Addiction, CurrentStatus, SinceWhenM, SinceWhenY, Frequency, Quantity };
				mydata.add(obj);
			}

			return mydata;
	

}
}

