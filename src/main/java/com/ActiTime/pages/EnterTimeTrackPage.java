package com.ActiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTime.genaric.BasePage;

public class EnterTimeTrackPage extends BasePage
{
	//Declaration
	@FindBy(id = "logoutLink")
	private WebElement logOutLink;
	
	//initilization
	public EnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//utlization
	public void clickOnLogOut()
	{
		logOutLink.click();
	}

}
