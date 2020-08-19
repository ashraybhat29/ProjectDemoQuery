package com.jqueryui.lib.ui;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.jqueryui.lib.util.DataHandlers;
import com.jqueryui.lib.util.Utility;


public class DatepickerPage
{
	
	
	String day;
	Utility utility;
	public By  ExampleTab            = By.xpath("//h2[text()='Examples']"); 
	public By  Formatdate            = By.linkText("Format date");
	public By  DateCalendar          = By.cssSelector("input#datepicker");
	public By  FormatOptions         = By.cssSelector("select#format");
	public By  currentDate           = By.className("ui-datepicker-title");
	public By  NextButton            = By.xpath("//span[text()='Next']");
	public By  PreviousButton        = By.xpath("//span[text()='Prev']");
	//public By  Date                  = By.xpath("//a[text()='"+Integer.parseInt(day)+"']");   
	
	WebDriver driver;
	public DatepickerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	 public String getExampleTab()
	    {
		 	
	    	String ExampleTest =driver.findElement(ExampleTab).getText();
	    	return ExampleTest;
	    }
	 
	 public void getFormatdateLink()
	    {
	    	driver.findElement(Formatdate).click();
	    }
	 
	 public WebElement DateCalendar()
	 {
		 return driver.findElement(DateCalendar);
	 }
	 
	 public WebElement selectFormatOptions()
	    {
	    	return driver.findElement(FormatOptions);
	    }
	 
	 public String currentDate()
	 {
		 String currentDateStr =driver.findElement(currentDate).getText();
	    	return currentDateStr;
	 }
	 
	 public void getNextButton()
	    {
	    	driver.findElement(NextButton).click();
	    }
	 
	 public void getPreviousButton()
	    {
	    	driver.findElement(PreviousButton).click();
	    }
	 
//	 public void getDate()
//	    {
//	    	driver.findElement(Date).click();
//	    }
	 public WebElement getIframe1()
		{
			return driver.findElement(By.cssSelector("iframe.demo-frame"));
		}
	 
	 public void waitForDropObjectToLoad()
		{
			WebDriverWait wait= new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
		}
	 
		//public void Datepicker(String datepass) throws InterruptedException, ParseException
		public void Datepicker(String datepass,String formatselect) throws InterruptedException, ParseException
		{
			waitForDropObjectToLoad();
			
			Thread.sleep(3000);
			Utility.captureScreenshot(driver, "datepicker");
			
			String exampletext         = getExampleTab(); 
			String expectedexampletext = "Examples";
			if(exampletext.contains(expectedexampletext)) 
			{
				getFormatdateLink();
				Thread.sleep(3000);
				driver.switchTo().frame(getIframe1());
				DateCalendar().isDisplayed();
				DateCalendar().click();
				currentDate();
				System.out.println(currentDate());
				String setDateStr =datepass;
				
				Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);
				Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currentDate());
				
				int monthDiff= Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1),new DateTime(setDate).withDayOfMonth(1)).getMonths();
				
				boolean isFuture = true;
				
				if(monthDiff<0)
				{
					isFuture=false;
					monthDiff=-1 * monthDiff;
				}
				
				for(int i=0;i<monthDiff; i++)
				{
				  if(isFuture)
					  getNextButton();
				  else
					  getPreviousButton();
					  
				}
				
				
				day=  new SimpleDateFormat("dd").format(setDate);
				//getDate();
				//driver.findElement(By.xpath("//a[text()='4']")).click();
				driver.findElement(By.xpath("//a[text()='"+Integer.parseInt(day)+"']")).click();
				
				
				Select select= new Select(selectFormatOptions());
				select.selectByVisibleText(formatselect);
				Utility.captureScreenshot(driver, "date selected");
				Thread.sleep(3000);
			
				
			}else {
				System.out.println("Error:DatePicker is not clicked. ");
			}
			

		}
		
		
}
