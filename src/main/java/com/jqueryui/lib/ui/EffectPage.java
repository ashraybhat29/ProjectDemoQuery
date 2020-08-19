package com.jqueryui.lib.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jqueryui.lib.util.Utility;

public class EffectPage {


	WebDriver driver;
	Utility utility;
	public By effectdropdown   = By.cssSelector("select#effectTypes");
	public By runEffectButton  = By.xpath("//button[text()='Run Effect']");
	
	public EffectPage(WebDriver driver)
	{
		this.driver=driver;
	}
		
	public WebElement getEffectDropDown()
	{
	    return driver.findElement(effectdropdown);
	}
	
	
	public void getRunEffectButton()
	{
		 driver.findElement(runEffectButton).click();
	}
	
	public void waitForEffectLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}
	
	public void effect(String sheetNum) throws InterruptedException
	{
		waitForEffectLoad();
		Utility.switchToFrame1(driver);
		
		try
        {
			
			File file = new File(System.getProperty("user.dir")+"\\TestData-for-Xls\\Effects.xls");
            FileInputStream iFile = new FileInputStream(file);

            HSSFWorkbook wb = new HSSFWorkbook(iFile);
            HSSFSheet sheet = wb.getSheet(sheetNum);

            int rowCount = sheet.getLastRowNum();
            System.out.println("the no of rows are : " + rowCount);
            for (int row=1; row<=rowCount; row++)
            {
                String effect = sheet.getRow(row).getCell(0).getStringCellValue();
                System.out.println(effect);
                
                Select selectEffect = new Select(getEffectDropDown());
                selectEffect.selectByVisibleText(effect);
                getRunEffectButton();
                Thread.sleep(3000);
             }               
            iFile.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		driver.switchTo().defaultContent();
		
		
	}
		
		
		
		
		
		
//		waitForEffectLoad();
//		
//		Thread.sleep(3000);
//		Utility.captureScreenshot(driver, "effect");
//		 Utility.switchToFrame1(driver);
//		//driver.switchTo().frame(getIframe1());
//		 Select select= new Select(getEffectDropDown());
//			select.selectByVisibleText(selecteffect);
//		 getRunEffectButton();
//		 Utility.captureScreenshot(driver, "selecteffectvalue");
//		 }

}

