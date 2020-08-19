package com.jqueryui.lib.util;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import com.excel.utility.XLs_Reader;


public class Utility {

	// static XLs_Reader reader;
	 
//	static WebDriver driver;
//	
//	public Utility(WebDriver driver)
//	{
//		this.driver=driver;
//	}
	public static void captureScreenshot(WebDriver driver, String screenshotname)
	{
		
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,
					new File("F:\\Ashray\\Selenium\\Projects\\Selenium_Jqueryui\\target\\"
							+ screenshotname + ".png"));
//			System.out.println("Screenshot Taken");
		} catch (Exception e) {

			System.out.println("Exception while taking Screenshot" +e.getMessage());
		}
	}
	
	public static void switchToFrame1(WebDriver driver)
	{
		WebElement myFrame=driver.findElement(By.cssSelector("iframe.demo-frame"));
		 driver.switchTo().frame(myFrame);
		 
	}
	

	
	
}
