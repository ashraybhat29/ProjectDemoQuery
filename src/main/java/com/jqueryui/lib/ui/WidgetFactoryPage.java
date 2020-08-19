package com.jqueryui.lib.ui;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jqueryui.lib.util.Utility;

public class WidgetFactoryPage {

	
	Utility utility;
	public By  WidgetFactoryWindow            = By.xpath("//h1[text()='Widget Factory']"); 
	public By  FirstChangeButton              = By.xpath("(//button[contains(text(),'change')])[1]");
	public By  BackgroundColor                = By.xpath("//div//div[@id='my-widget1']");
	public By  SecondChangeButton             = By.xpath("(//button[contains(text(),'change')])[2]");
	public By  FontColor                      = By.xpath("//div//div[@id='my-widget2']");
	public By  ThirdChangeButton              = By.xpath("(//button[contains(text(),'change')])[3]");
	public By  FontSize                       = By.xpath("//div//div[@id='my-widget3']");
	public String flatFileString  			   = System.getProperty("user.dir")+"\\TestData\\productfeature.txt";
	
	
	WebDriver driver;
	public WidgetFactoryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	 public String getWidgetFactoryWindow()
	    {
		 	
	    	String WidgetFactoryText =driver.findElement(WidgetFactoryWindow).getText();
	    	return WidgetFactoryText;
	    }
	public void getChange1Button()
    {
	 driver.findElement(FirstChangeButton).click();
    }
	
	
	public String getChange1BackgroundColor()
    {
	 String btn1backgroundColor= driver.findElement(BackgroundColor).getCssValue("background-color");
	 return btn1backgroundColor;
    }
	
	public void getChange2Button()
    {
	  driver.findElement(SecondChangeButton);
    }
	
	public String getChange2FontColor()
    {
		String fontcolor= driver.findElement(FontColor).getCssValue("color");
		 return fontcolor;

    }
	
	
	public void getChange3Button()
    {
	 driver.findElement(ThirdChangeButton);
    }
	
	public String getChange3FontSize()
    {
		String fontSize= driver.findElement(FontSize).getCssValue("font-size");
		 return fontSize;
	
    }
	
	public WebElement getIframe1()
	{
		return driver.findElement(By.cssSelector("iframe.demo-frame"));
	}
	public void waitForWidgetFactoryLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}
	
	public void WidgetFactory() throws InterruptedException, IOException
	{
		waitForWidgetFactoryLoad();
		
		Thread.sleep(3000);
		Utility.captureScreenshot(driver, "widgetfactory");
		//Step 3 
		String widgettext         = getWidgetFactoryWindow(); 
		String expectedwidgettext = "Widget Factory";
		if(widgettext.contains(expectedwidgettext)) 
		{
			
			driver.switchTo().frame(getIframe1());
		//step 4
	    String btnBackgroundColor= getChange1BackgroundColor();
	    System.out.println(btnBackgroundColor);
	    String hexbtnBackgroundColor=Color.fromString(btnBackgroundColor).asHex();
		System.out.println("background color:"+hexbtnBackgroundColor);
		getChange1Button();
		
		String aftClickBackgroundColor=getChange1BackgroundColor();
		String afthexhexbtnBackgroundColor=Color.fromString(aftClickBackgroundColor).asHex();
		System.out.println(afthexhexbtnBackgroundColor);
		if(aftClickBackgroundColor != afthexhexbtnBackgroundColor)
		{
			System.out.println("Color got changed after button click");
			//step 5
			getChange2Button();
			getChange2FontColor();
			String btn2FontColor=getChange2FontColor();
			String hexfontColor=Color.fromString(btn2FontColor).asHex();
			System.out.println("font color:"+hexfontColor);
			//step 6
			getChange3Button();
			getChange3FontSize();
			String btn3FontSize=getChange3FontSize();
			System.out.println("font size:"+btn3FontSize);
			// step 7 click on Go black is not there in the page hence skipping
			//step 8
			String lineSeparator = System.getProperty("line.separator");
			 FileWriter flatFile=new FileWriter(flatFileString);    
				flatFile.flush();
				flatFile.write(afthexhexbtnBackgroundColor);  
				flatFile.write(lineSeparator);
				flatFile.write(hexfontColor);   
				flatFile.write(lineSeparator);
				flatFile.write(btn3FontSize);   
				flatFile.close(); 
				Utility.captureScreenshot(driver, "WFactstep8");
		}
		else
		{
			
			System.out.println("Color didnt get changed after button click");
		}
		
		}
		else {
			System.out.println("Error:Widget Facoty is not clicked. ");
		}
		
		
	}
	
}
