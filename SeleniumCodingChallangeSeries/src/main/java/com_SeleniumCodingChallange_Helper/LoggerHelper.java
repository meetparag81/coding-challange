package com_SeleniumCodingChallange_Helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class LoggerHelper
{
private static boolean root = false;
	
	public static Logger getLogger(Class cls)
	{
		if(root=false)
		{
			return Logger.getLogger(cls);
			
		}
		else
		{
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\src\\main\\resources\\log4j.properties"));
		root=true;
		}
		return Logger.getLogger(cls);
	
	}
	
	public static void main(String[] args) 
	{
	
		
		
		
	}

}
