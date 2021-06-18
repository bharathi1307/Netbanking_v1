package com.NetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;

	public  AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	public WebElement likAddNewCustomer;

	@FindBy(xpath="//*[@name=\"name\"]")
	public WebElement txtCustomerName; 

	@FindBy(xpath="(//*[@type=\"radio\"])[2]")
	public WebElement Gender;

	@FindBy(xpath="(//*[@type=\"date\"])")
	public WebElement txtdob;

	@FindBy(xpath="(//*[@name=\"addr\"])")
	public WebElement txtaddress;

	@FindBy(xpath="(//*[@name=\"city\"])")
	public WebElement txtcity;

	@FindBy(xpath="(//*[@name=\"state\"])")
	public WebElement txtstate;

	@FindBy(xpath="(//*[@name=\"pinno\"])")
	public WebElement txtpinno;

	@FindBy(xpath="(//*[@name=\"telephoneno\"])")
	public WebElement txttelephoneno;

	@FindBy(xpath="(//*[@name=\"emailid\"])")
	public WebElement txtemailid;

	@FindBy(xpath="(//*[@name=\"password\"])")
	public WebElement txtpassword;

	@FindBy(xpath="(//*[@name=\"sub\"])")
	public WebElement btnSubmit;

	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	public WebElement logout;


	public void clickAddNewCustomer() {
		likAddNewCustomer.click();

	} 

	public void custName(String cname) {

		txtCustomerName.sendKeys(cname);
	}

	public void custgender(String cgender) {
		Gender.click();
	}
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}

	



}
