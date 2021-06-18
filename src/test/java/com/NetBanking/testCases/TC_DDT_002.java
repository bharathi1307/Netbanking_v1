package com.NetBanking.testCases;

import java.io.IOException;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.NetBanking.pageObjects.LoginPage;
import com.NetBanking.utilites.XLUtils;

@Test(dataProvider="LoginData")
public class TC_DDT_002 extends BaseClass{
	public void loginDDT(String name, String pwd) throws InterruptedException
	{
		driver.get(baseurl); 

		LoginPage lp =new LoginPage(driver);
		lp.setUserName(name);
		logger.info("User name provider");
		lp.setPassword(pwd);
		logger.info("User password provider");
		lp.clickSubmit();
		if(isAlterPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close the logout
			driver.switchTo().defaultContent();
		}

	}
	public boolean isAlterPresent()//Userdefined Method created to check alert
	{
		try {
			driver.switchTo().alert();
			return true;
		}catch (NoAlertPresentException e) {
			return false;

		}

	}

	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\NetBanking\\testData\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}

		}
		return logindata;
	}
}
