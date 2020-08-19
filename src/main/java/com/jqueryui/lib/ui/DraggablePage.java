package com.jqueryui.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jqueryui.lib.util.Utility;

public class DraggablePage {

	Utility utility;
	public By  DragMeAroundElement              = By.cssSelector("html>body>div#draggable"); 



	WebDriver driver;
	public DraggablePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement DragMeAroundElement()
    {
    	return driver.findElement(DragMeAroundElement);
    }
 
	 public WebElement getIframe1()
		{
			return driver.findElement(By.cssSelector("iframe.demo-frame"));
		}
	
	
	public void waitForDragObjectToLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}
	
	public void draggable() throws InterruptedException
	{
		waitForDragObjectToLoad();
		driver.switchTo().frame(getIframe1());
		Thread.sleep(1000);
		Utility.captureScreenshot(driver, "draggablepage");
		if(DragMeAroundElement().isDisplayed())
		{
		WebElement move = DragMeAroundElement();
		Point beforemove=move.getLocation();
		Actions act= new Actions(driver);
		act.dragAndDropBy(move,200, 130).perform();
		Utility.captureScreenshot(driver,"drop");
		
		Point aftermove=move.getLocation();
		if( beforemove!= aftermove )
		{
			driver.switchTo().defaultContent();
			System.out.println("DragMe is successfull");
		}
		else
		{
			System.out.println("DragMe is not successfull");
		}
		 }
		else
		   {
			  System.out.println("Error: Resizable Page is not displayed");
		   }

	}
}
