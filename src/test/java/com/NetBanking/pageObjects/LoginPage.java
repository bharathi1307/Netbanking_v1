package com.NetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name="uid")
	WebElement txtUserName;

	@FindBy(name="password")
	WebElement txtpassword;

	@FindBy(name="btnLogin")
	WebElement btnnLogin;

	@FindBy(xpath="//*[text()='Log out']")
	WebElement Logout;


	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);

	}

	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);

	}
	public void clickSubmit() {
		btnnLogin.click();
	}
	public void clickLogout()
	{
	Logout.click();
	}
}

