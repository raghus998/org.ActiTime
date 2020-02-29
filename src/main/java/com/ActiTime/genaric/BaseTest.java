package com.ActiTime.genaric;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

abstract public class BaseTest implements AutoConstants {
	public WebDriver driver;
	static {
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(firefox_key, firefox_value);
	}
	@Parameters({"nodeUrl","BrowserName","AppUrl"})
	@BeforeMethod
	public void preCondition(String nodeUrl,String BrowserName,String AppUrl) throws MalformedURLException 
	{
		URL url = new URL(nodeUrl);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(BrowserName);
		driver = new RemoteWebDriver(url, dc);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(AppUrl);
	}

	@AfterMethod
	public void postCondition(ITestResult res) throws IOException {
		int status = res.getStatus();
		if (status == 2) {
			String name = res.getName();
			GenaricUtils.takeScreenshot(driver, name);
		}
		driver.close();

	}

}
