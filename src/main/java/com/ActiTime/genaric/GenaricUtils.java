package com.ActiTime.genaric;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenaricUtils
{
	
	public static void takeScreenshot(WebDriver driver,String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+name+".png");
		FileUtils.copyFile(src, dest);
	}
	
	
	public static void selectByIndex(WebElement ele,int index)
	{
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement ele,String value)
	{
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement ele,String text)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
		
	}

}
