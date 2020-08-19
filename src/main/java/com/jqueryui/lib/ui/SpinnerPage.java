package com.jqueryui.lib.ui;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.jqueryui.lib.util.Utility;

public class SpinnerPage {

	WebDriver driver;
	public By  SpinnerUpArrowButton           = By.xpath("(//body//p//span//a//span)[1]");
	public By  SetValueTo5Button              = By.cssSelector("body>p>button#setvalue");
	public By  SpinnerDownArrowButton         = By.xpath("(//body//p//span//a//span)[3]");
	public By  GetValue						  = By.cssSelector("body>p>button#getvalue");
	
	public SpinnerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void getSpinnerUpArrowButton()
	{
		 driver.findElement(SpinnerUpArrowButton).click();
	}
	public void getSpinnerDownArrowButton()
	{
		 driver.findElement(SpinnerDownArrowButton).click();
	}
	public void getSetValueTo5Button()
	{
		 driver.findElement(SetValueTo5Button).click();
	}
	public void geGetValueButton()
	{
		 driver.findElement(GetValue).click();
	}
	
	public void waitForSpinnerLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}
	
	
	public void Spinner() throws InterruptedException
	{
		    Reporter.log("I Clicked on Spinner link");
		    waitForSpinnerLoad();
		    Thread.sleep(3000);
		    Utility.captureScreenshot(driver, "Spinner");
		    Utility.switchToFrame1(driver);
		    
		    getSpinnerUpArrowButton();
		    getSpinnerUpArrowButton();
		    getSetValueTo5Button();
		    geGetValueButton();
			Reporter.log("Spinner validation is successfull");
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "5");
			alert.accept();
			driver.switchTo().defaultContent();
	
	}
	
}

