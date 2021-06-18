package com.NetBanking.testCases;

import org.testng.annotations.Test;

import com.NetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {
	

	@Test
	public void loginTest() throws Exception
	{
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password ");
		lp.clickSubmit();

		System.out.print(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login is passed");
		}
			else
			{
				 
				Assert.assertTrue(false);
				logger.info("login is failed");
			}

	}
}
