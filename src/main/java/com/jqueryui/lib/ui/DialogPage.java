package com.jqueryui.lib.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.jqueryui.lib.util.Utility;

public class DialogPage {

	
	Utility utility;
	public By  DialogWindow            = By.xpath("//h1[text()='Dialog']"); 
	public By  Animation			   = By.linkText("Animation");
	public By  ModalForm               = By.linkText("Modal form");
	public By  DialogButton            = By.cssSelector("html>body>button#opener");
	public By  BasicDialogBox          = By.xpath("//body//div//div//span[text()='Basic dialog']");
	public By  ExistingUsersText       = By.xpath("//div[@id='users-contain']//h1");
	public By  CreateNewUserButton     = By.cssSelector("html>body>button#create-user");
	public By  UserNameTextBox         = By.cssSelector("input[type=text][name=name][id=name]");
	public By  NewUserEmailTextBox     = By.cssSelector("input[type=text][name=email][id=email]");
	public By  NewUserPasswordTextBox  = By.cssSelector("input[type=password][name=password][id=password]");
	public By  CreateAnAccountButton   = By.xpath("//button[text()='Create an account']");
	public By  DialogRecords           = By.xpath("//table[@id='users']//tbody//tr");
	
	
	WebDriver driver;
	public DialogPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	 public String getDialogWindow()
	    {
		 	
	    	String DialogWindowText =driver.findElement(DialogWindow).getText();
	    	return DialogWindowText;
	    }
	
	public void getAnimationLink()
    {
	 driver.findElement(Animation).click();
    }
	
	public void getModalFormLink()
    {
	 driver.findElement(ModalForm).click();
    }

	
	public WebElement getIframe1()
	{
		return driver.findElement(By.cssSelector("iframe.demo-frame"));
	}
	public void waitForDialogLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}
	
	public WebElement getOpenDialogButton()
    {
	  return driver.findElement(DialogButton);
    }
	
	public String getBasicDialogBox()
	{
		String BasicDialogText=  driver.findElement(BasicDialogBox).getText();
		return BasicDialogText;
	}
	
	public String getExistingUsersText()
	    {
		  String ExitingUserText=  driver.findElement(ExistingUsersText).getText();
		  return  ExitingUserText;
	    }
	
	public void getCreateNewUserButton()
	{
		 driver.findElement(CreateNewUserButton).click();
	}
	
	public WebElement getCreateNewUserNameTextBox()
	{
		return driver.findElement(UserNameTextBox);
	}
	public WebElement getCreateNewUserEmailTextBox()
	{
		return driver.findElement(NewUserEmailTextBox);
	}
	
	public WebElement getCreateNewUserPasswordTextBox()
	{
		return driver.findElement(NewUserPasswordTextBox);
	}
	
	public void getCreateAnAccountButton()
	{
		 driver.findElement(CreateAnAccountButton).click();
	}	
	
	public List <WebElement> getDialogRecords()
	{
		return driver.findElements(DialogRecords);
	}
	
	
	public void Dialog(String Name,String Email, String Password) throws InterruptedException
	{

		waitForDialogLoad();
		
		Thread.sleep(3000);
		Utility.captureScreenshot(driver, "Dialog");
		//Step 3 
		String Dialogtext         = getDialogWindow(); 
		String ExpectedDialogtext = "Dialog";
		if(Dialogtext.contains(ExpectedDialogtext)) 
		{
			
			getAnimationLink();
			driver.switchTo().frame(getIframe1());
			getOpenDialogButton().isDisplayed();
			getOpenDialogButton().click();
			Reporter.log("I Clicked on Animation link");
			if(getBasicDialogBox().contains("Basic dialog"))
			{
				System.out.println("Basic dialog box is displayed");
				
				driver.switchTo().defaultContent();
				getModalFormLink();
				driver.switchTo().frame(getIframe1());
				if(getExistingUsersText().contains("Existing Users"))
				{
					 List <WebElement> noofRecords= getDialogRecords();
			          int total_count=noofRecords.size();
			          System.out.println("No of records before adding: "+total_count);
					getCreateNewUserButton();
					getCreateNewUserNameTextBox().clear();
					getCreateNewUserEmailTextBox().clear();
					getCreateNewUserPasswordTextBox().clear();
					getCreateNewUserNameTextBox().sendKeys(Name);
					getCreateNewUserEmailTextBox().sendKeys(Email);
					getCreateNewUserPasswordTextBox().sendKeys(Password);
					getCreateAnAccountButton();
					
					 List <WebElement> noofRecordsAdded= getDialogRecords();
			          int total_count_after=noofRecords.size();
			          System.out.println("No of records after adding:"+total_count_after);
			          Utility.captureScreenshot(driver, "Dialogrecrods");
			          Thread.sleep(4000);
			          if(total_count>= total_count_after)
			          {
			        	  driver.switchTo().defaultContent();
			        	  System.out.println("Records added successfully");
			          }
			          else
			          {
			        	  System.out.println("Records not saved");
			          }
				}
				else
				{
					System.out.println("Existing USer is not displayed");
				}
			}
			else
			{
				System.out.println("Basic dialog box  is not displayed");
			}
			
		}
		else
		{
			System.out.println("Dialog Window is not displayed");
		}
	}
	

}

