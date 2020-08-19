package com.jqueryui.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jqueryui.lib.util.Utility;

public class DroppablePage {

	Utility utility;
	public By  DragMeToTargetElement            = By.cssSelector("html>body>div#draggable"); 
	public By  DropHereElement                  = By.cssSelector("html>body>div#droppable");
	
	
	WebDriver driver;
	public DroppablePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	 public WebElement DragMeToTargetElement()
	    {
	    	return driver.findElement(DragMeToTargetElement);
	    }
	 
	 public WebElement DropHereElement()
	    {
	    	return driver.findElement(DropHereElement);
	    }
	 public WebElement getIframe1()
		{
			return driver.findElement(By.cssSelector("iframe.demo-frame"));
		}

	public void waitForDropObjectToLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}
	
	
	public void droppable() throws InterruptedException
	{
		waitForDropObjectToLoad();
		driver.switchTo().frame(getIframe1());
		Thread.sleep(1000);
		Utility.captureScreenshot(driver, "droppablepage");
		WebElement Drag=DragMeToTargetElement();
		Point beforedrag=Drag.getLocation();
		if(DragMeToTargetElement().isDisplayed() && DropHereElement().isDisplayed())
		{
			WebElement source = DragMeToTargetElement();
			WebElement target=DropHereElement();
			Actions act= new Actions(driver);
			act.dragAndDrop(source, target).perform();
			Utility.captureScreenshot(driver,"dragdrop");
			Point afterdrag=Drag.getLocation();
			if( beforedrag!= afterdrag )
			{
				driver.switchTo().defaultContent();
				System.out.println("Drag is successfull");
			}
			else
			{
				System.out.println("Drag is not successfull");
			}
		}
		else
		{
			System.out.println("Error: Droppable Page is not displayed");
		}
	}
}
