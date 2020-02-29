package com.ActiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.genaric.BasePage;

public class LoginPage  extends BasePage
{
	//Declaration
	@FindBy(id = "username")
	private WebElement unTb;
	
	@FindBy(name = "pwd")
	private WebElement pwTb;
	
	@FindBy(id = "loginButton")
	private WebElement logInBtn;
	
	@FindBy(xpath = "//span[contains(.,'Username or Password')]")
	private WebElement errorMsg;
	
	@FindBy(xpath = "(//nobr[contains(.,'actiTIME')])[1]")
	private WebElement version;
	
	
	//initilization
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	//utlization
	public void verifyPageTitle(String eTitle)
	{
		verifyTitle(eTitle);
	}
	
	public void enterUserName(String un)
	{
		unTb.sendKeys(un);
	}
	
	public void enterPassword(String pw)
	{
		pwTb.sendKeys(pw);
	}
	
	public void clickOnLogInBtn()
	{
		logInBtn.click();
	}
	
	public String verifyErrorMsg()
	{
		verifyElement(errorMsg);
		String errorText = errorMsg.getText();
		return errorText;
	}
	
	public String verifyVersion()
	{
		verifyElement(version);
		String versionText = version.getText();
		return versionText;
		
	}
}
