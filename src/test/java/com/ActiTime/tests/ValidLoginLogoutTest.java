package com.ActiTime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ActiTime.genaric.BaseTest;
import com.ActiTime.genaric.ExcelData;
import com.ActiTime.pages.EnterTimeTrackPage;
import com.ActiTime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority = 1)
	public void testValidLoginLogout()
	{
		//Reading data from excel sheet
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String enterTitle = ExcelData.getData(file_path, "TC01", 1, 3);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		 
		 
		 //verify LoginTitle
		 lp.verifyPageTitle(loginTitle);
		 
		 //Enter un
		 Reporter.log("UserName is : "+un,true);
		 lp.enterUserName(un);
		 
		 //Enter pw
		 Reporter.log("Password is : "+pw,true);
		 lp.enterPassword(pw);
		 
		 //Click on loginBtn
		 lp.clickOnLogInBtn();
		 
		 
		 //verify EnterTimeTrackTitle
		 lp.verifyPageTitle(enterTitle);
		 
		 //Clickon Logout
		 ep.clickOnLogOut();
		 
		 //verify LoginTitle
		 lp.verifyPageTitle(loginTitle);
		 
	}

}
