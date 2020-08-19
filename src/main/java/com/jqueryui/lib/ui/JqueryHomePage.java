package com.jqueryui.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jqueryui.lib.config.CreateDrivers;
import com.jqueryui.lib.util.DataHandlers;

public class JqueryHomePage extends CreateDrivers{

	
	
	 WebDriver driver;
	
	public By  Droppablelink            = By.linkText("Droppable"); 
	public By  MaximumMinimumsizeLink   = By.linkText("Maximum / minimum size");
	public By  DraggableLink            = By.linkText("Draggable");
	public By  ResizableLink            = By.linkText("Resizable");
	public By  DialogLink               = By.linkText("Dialog");
	public By  SpinnerLink              = By.linkText("Spinner");
	public By  ColorAnimationLink       = By.linkText("Color Animation");
	public By  TooltipLink              = By.linkText("Tooltip");
	public By  EffectLink               = By.linkText("Effect");
	public By  HideLink                 = By.linkText("Hide");
	public By  WidgetFactoryLink        = By.linkText("Widget Factory");
	public By  JqueryLogo               = By.cssSelector("div>h2.logo>a");
	public By  DatePickerLink           = By.linkText("Datepicker");
	public By  ShowLink                 = By.linkText("Show");
	
	
	public JqueryHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public  void waitForJQueryPageToLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div>h2.logo>a"))));
	}
	
    public void clickMaximumMinimumsizeLink()
    {
    	driver.findElement(MaximumMinimumsizeLink).click();
    }
    public void clickDroppableLink()
    {
    	driver.findElement(Droppablelink).click();
	
    }
    
    public void clickDraggableLink()
    {
    	driver.findElement(DraggableLink).click();
	
    }
    
    public void clickResizableLink()
    {
    	driver.findElement(ResizableLink).click();
		
    }
    
    public void clickDialogLink()
    {
    	driver.findElement(DialogLink).click();
		
    }
    
    public void clickSpinnerLink()
    {
    	driver.findElement(SpinnerLink).click();
		
    }
    
    public void clickColorAnimationLink()
    {
    	driver.findElement(ColorAnimationLink).click();
		
    }
    
    public void clickTooltipLink()
    {
    	driver.findElement(TooltipLink).click();
		
    }
    
    public void clickEffectLink()
    {
    	driver.findElement(EffectLink).click();
		
    }
    
    public void clickHideLink()
    {
    	driver.findElement(HideLink).click();
		
    }
    
    public void clickShowLink()
    {
    	driver.findElement(ShowLink).click();
		
    }
    public void clickWidgetFactoryLink()
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,2500)");
    	driver.findElement(WidgetFactoryLink).click();
		
    }
    
    public void clickDatePickerLink()
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,250)");
    	driver.findElement(DatePickerLink).click();
		
    }
}
