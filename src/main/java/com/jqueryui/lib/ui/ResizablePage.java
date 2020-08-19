package com.jqueryui.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jqueryui.lib.util.Utility;

public class ResizablePage {


	Utility utility;
	public By  ResizableElement              = By.xpath("//div[@id='resizable']/div[3]"); 

	WebDriver driver;
	public ResizablePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement ResizableElement()
    {
	return driver.findElement(ResizableElement);
    }
	
	
	public WebElement getIframe1()
	{
		return driver.findElement(By.cssSelector("iframe.demo-frame"));
	}
	public void waitForResizableLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}
	
	public void resizeable() throws InterruptedException
	{
		waitForResizableLoad();
		driver.switchTo().frame(getIframe1());
		Thread.sleep(1000);
		Utility.captureScreenshot(driver, "Resizepage");
		if(ResizableElement().isDisplayed())
		{
		   WebElement resize = ResizableElement();
	
		   Point beforeresize=resize.getLocation();
		   System.out.println("xy before click"+beforeresize);
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,2500)");
		
		   Actions act= new Actions(driver);
		   act.clickAndHold(resize).moveByOffset(150,50).release(resize).build().perform();
		   Utility.captureScreenshot(driver,"resize");
		   System.out.println("xy after click"+beforeresize);
	       Point afterresize=resize.getLocation();
		     if( beforeresize!= afterresize )
		        {
		        	driver.switchTo().defaultContent();
			        System.out.println("Resize is successfull");
		        }
		     else
		        {
			        System.out.println("Resize is not successfull");
		        }
		 }
		else
		   {
			  System.out.println("Error: Resizable Page is not displayed");
		   }
		
	}
}
