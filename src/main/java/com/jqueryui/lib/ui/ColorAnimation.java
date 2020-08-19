package com.jqueryui.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jqueryui.lib.util.Utility;

public class ColorAnimation {
	
	
	WebDriver driver;
	
	public By ToggleEffectButton     = By.cssSelector("button#button"); 
	public By ToggleEffectFeature      = By.cssSelector("div#effect");
	public By CustomContent     = By.linkText("Custom content");
	
	public ColorAnimation(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void getToggleEffectButton()
    {
	 driver.findElement(ToggleEffectButton).click();
    }
	
	public WebElement getToggleEffectFeature()
	{
		return driver.findElement(ToggleEffectFeature);
	}
	
	
	public String getToggelEffectBackgroundColor()
    {
	 String backgroundColor= driver.findElement(ToggleEffectFeature).getCssValue("background-color");
	 return backgroundColor;
    }
	
	public String getToggelEffectFontSize()
    {
		String fontSize= driver.findElement(ToggleEffectFeature).getCssValue("font-size");
		 return fontSize;
	
    }
	
	public WebElement getIframe1()
	{
		return driver.findElement(By.cssSelector("iframe.demo-frame"));
	}
	public void waitForColorAnimationLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}

	public void ColorAnimation() throws InterruptedException
	{
		try
		{
			
		
		waitForColorAnimationLoad();
		driver.switchTo().frame(getIframe1());
		Thread.sleep(1000);
		Utility.captureScreenshot(driver, "coloranimationpage");
		if(getToggleEffectFeature().isDisplayed())
		{
		   WebElement resize = getToggleEffectFeature();
	
		   Point beforeresize=resize.getLocation();
		   //background
		   String backgroundColor= getToggelEffectBackgroundColor();
		    System.out.println(backgroundColor);
		    String hexbackgroundColor=Color.fromString(backgroundColor).asHex();
			System.out.println("background color Before:"+hexbackgroundColor);
			
		   getToggleEffectButton();
		   Thread.sleep(3000);
		   
		   Point afterresize=resize.getLocation();
		   Thread.sleep(2000);
		   String aftbackgroundColor= getToggelEffectBackgroundColor();
		    System.out.println(aftbackgroundColor);
		    String afthexbackgroundColor=Color.fromString(aftbackgroundColor).asHex();
			System.out.println("background color After:"+afthexbackgroundColor);
			//font size
			String aftfontSize=getToggelEffectFontSize();
			System.out.println("font size aft:"+aftfontSize);
			
		     if( beforeresize!= afterresize && afthexbackgroundColor!=hexbackgroundColor)
		        {
		        	driver.switchTo().defaultContent();
		        //	System.out.println("xy before click"+beforeresize);
		        //	System.out.println("xy after click"+afterresize);
			        System.out.println("X and Y coordinates changed successfull");
		        }
		     else
		        {
			        System.out.println("X and Y coordinates change is not successfull");
		        }
		 }
		else
		   {
			  System.out.println("Error: ColorAnimation Page is not displayed");
		   }
		}catch(Exception e) {
			System.out.println(e);
		}
		{
			
		}
		}
	
}
