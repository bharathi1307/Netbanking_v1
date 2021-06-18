package com.NetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.NetBanking.pageObjects.AddCustomerPage;
import com.NetBanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws Throwable
	{
	//	driver.get(baseurl); 
		driver.manage().window().maximize();
		LoginPage lp =new LoginPage(driver);
		AddCustomerPage addcust= new AddCustomerPage(driver);
		lp.setUserName(username);
		logger.info("Username is provider");
		lp.setPassword(password);
		logger.info("Password is provider");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		addcust.clickAddNewCustomer();
		logger.info("customer details provider ");
		addcust.custName("Pavan");
		addcust.custgender("Femail");
		addcust.custdob("10", "05", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("chenai");
		addcust.custstate("TN");
		addcust.custpinno("600029");
		addcust.custtelephoneno("9962690716");
		//addcust.custemailid("bharathi@gamil.com");
		//addcust.custName("bharathi");
		String email =randomestring()+"@gamil.com";
		addcust.custemailid(email);
		addcust.custpassword("bharathi");
		Thread.sleep(3000);
		addcust.custsubmit();

		logger.info("Validated thedata");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed......");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("test case failed......");
		}
		
	}

	public String randomestring() {

		String generateString=RandomStringUtils.randomAlphabetic(6);
		return generateString;

	}
	
}
