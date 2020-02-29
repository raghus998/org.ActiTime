package com.ActiTime.genaric;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * @author Mercury
 *
 */
public class BasePage 
{
	WebDriver driver;

	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * @param eTitle
	 */
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try 
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Both the title are matching :"+eTitle,true);
		} 
		catch (Exception e) 
		{
			Reporter.log("Title is not matching.Expected Title is :"+eTitle,true);
			Reporter.log("Actual Title is : "+driver.getTitle(),true);
			Assert.fail();
		 }
	}
	
	/**
	 * @param element
	 */
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is Present.",true);
		} 
		catch (Exception e) 
		{
			Reporter.log("Element is not displayed",true);
			Assert.fail();	
		}
		
	}

}
