package com.acti.utils;

import com.acti.base.DriverScript;

public class Helper extends DriverScript {
	
	public static void sleep()
	{
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
