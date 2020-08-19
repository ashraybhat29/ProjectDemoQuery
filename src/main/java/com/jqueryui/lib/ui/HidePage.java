package com.jqueryui.lib.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jqueryui.lib.util.Utility;

public class HidePage {
	
	


	WebDriver driver;
	Utility utility;
	public By hidedropdown   = By.cssSelector("select#effectTypes");
	public By runEffectButton  = By.xpath("//button[text()='Run Effect']");
	
	public HidePage(WebDriver driver)
	{
		this.driver=driver;
	}
		
	public WebElement getHideDropDown()
	{
	    return driver.findElement(hidedropdown);
	}
	
	
	public void getRunEffectButton()
	{
		 driver.findElement(runEffectButton).click();
	}
	
	
	public void waitForHideLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.demo-frame"))));
	}
	
	public void hide(String sheetNum) throws InterruptedException
	{
		waitForHideLoad();
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
                
                Select selectEffect = new Select(getHideDropDown());
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


}
