package com.jqueryui.lib.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.jqueryui.lib.util.Utility;

public class ToolTipPage {

	
	
	WebDriver driver;
	public By TooltipWindow     = By.xpath("//h1[text()='Tooltip']"); 
	public By TooltipImage      = By.xpath("//img[@class='ui-corner-all']");
	
	public By selectpic         = By.xpath("//body//div[@class='ui-widget photo'][2]");
	public By CustomContent     = By.linkText("Custom content");
	
	public ToolTipPage(WebDriver driver)
	
	{
		this.driver=driver;
	}
	 public String getTooltipWindow()
	    {
		 	
	    	String TooltipWindowText =driver.findElement(TooltipWindow).getText();
	    	return TooltipWindowText;
	    }
	public void getCutomContenLink()
    {
	 driver.findElement(By.linkText("Custom content")).click();
    }
	
	public WebElement getIframe1()
	{
		return driver.findElement(By.cssSelector("iframe.demo-frame"));
	}
	public void waitForTooltipLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}
	
	public WebElement getTooltipImg()
	{
	    return driver.findElement(TooltipImage);
	}
	
	public WebElement getImg()
	{
	    return driver.findElement(selectpic);
	}
	
	public void Tooltip() throws InterruptedException, IOException
	{

		waitForTooltipLoad();
		Reporter.log("I Clicked on ToolTip link");
		getCutomContenLink();
		Reporter.log("I Clicked on Custom Content link");
		Thread.sleep(3000);
		Utility.switchToFrame1(driver);
		WebElement logo = getTooltipImg();
	    String logoSRC = logo.getAttribute("src"); 
	    URL imageURL = new URL(logoSRC);
	    Thread.sleep(5000);
	    BufferedImage saveImage = ImageIO.read(imageURL);
	    ImageIO.write(saveImage, "jpg", new File("tower.jpg"));
	    Thread.sleep(5000);
		System.out.println("Image saved successfully in the project directory");
		Reporter.log("Image saved successfully in the project directory");

	}
}
		
