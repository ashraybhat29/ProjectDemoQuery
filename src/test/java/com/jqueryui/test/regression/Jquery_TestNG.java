package com.jqueryui.test.regression;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jqueryui.lib.config.CreateDrivers;
import com.jqueryui.lib.ui.ColorAnimation;
import com.jqueryui.lib.ui.DatepickerPage;
import com.jqueryui.lib.ui.DialogPage;
import com.jqueryui.lib.ui.DraggablePage;
import com.jqueryui.lib.ui.DroppablePage;
import com.jqueryui.lib.ui.EffectPage;
import com.jqueryui.lib.ui.HidePage;
import com.jqueryui.lib.ui.JqueryHomePage;
import com.jqueryui.lib.ui.ResizablePage;
import com.jqueryui.lib.ui.ShowPage;
import com.jqueryui.lib.ui.SpinnerPage;
import com.jqueryui.lib.ui.ToolTipPage;
import com.jqueryui.lib.ui.WidgetFactoryPage;
import com.jqueryui.lib.util.DataHandlers;
import com.jqueryui.lib.util.Utility;



public class Jquery_TestNG extends CreateDrivers {

	//private static final boolean WebElement = false;
	WebDriver 			driver;
	JqueryHomePage 		Jqueryhome;
	DroppablePage 		droppablelink;
	DraggablePage 		draggablelink;
	ResizablePage		resizeablelink;
	DatepickerPage 		datepickerlink;
	WidgetFactoryPage 	widgetfactorylink;
	DialogPage        	dialoglink;
	SpinnerPage         spinnerlink;
	ToolTipPage         tooltiplink;
	ColorAnimation      coloranimationlink;
	EffectPage          effectpagelink;
	HidePage            hidepagelink;
	ShowPage            showpagelink;
	
	
	Utility utility;
	String dialogname      =  DataHandlers.getDataFromExcel("data","TC02", 1, 0);   
	String dialogemail     =  DataHandlers.getDataFromExcel("data","TC02", 1, 1);   
	String dialogpassword  =  DataHandlers.getDataFromExcel("data","TC02", 1, 2);   
	
	public static Logger log = LogManager.getLogger(CreateDrivers.class.getName());
	
	@BeforeMethod
	public void precondition() throws Exception
	{
		
		driver              = CreateDrivers.getDriverInstance();
		Jqueryhome          = new JqueryHomePage(driver);
		droppablelink       = new DroppablePage(driver);
		draggablelink       = new DraggablePage(driver);
		resizeablelink      = new ResizablePage(driver);
		datepickerlink      = new DatepickerPage(driver);
		widgetfactorylink   = new WidgetFactoryPage(driver);
		dialoglink          = new DialogPage(driver);
		spinnerlink			= new SpinnerPage(driver);
		tooltiplink         = new ToolTipPage(driver);
		coloranimationlink  = new ColorAnimation(driver);
		effectpagelink      = new EffectPage(driver);
		hidepagelink        = new HidePage(driver);
		showpagelink        = new ShowPage(driver);
		
		//wait for Jquery page
		Jqueryhome.waitForJQueryPageToLoad();
		log.info("Jquery UI loaded");
		//get title and verify
		Utility.captureScreenshot(driver, "JqueryPage");
	}		

		
	   @Test
		public void TC001() throws InterruptedException
		{
			//Step 3   
			Reporter.log("Test case 1");
			Jqueryhome.clickDroppableLink();
			log.info("Clicked on Droppable");
			//Step 4
			Reporter.log("Clicked on Droppable Link");
			droppablelink.droppable();
			Reporter.log("Dragged and Dropped sucessfully!");
			//Step 5
			Jqueryhome.clickDraggableLink();
			log.fatal("check fatal");
			//Step 6
			Reporter.log("Clicked on Draggable Link");
			draggablelink.draggable();
			Reporter.log("Object Dragged sucessfully!");
			log.error("check Error");
			//Step 7
			Jqueryhome.clickResizableLink();
			//Step 8
			Reporter.log("Clicked on Resizable Link");
		    resizeablelink.resizeable();
		    Reporter.log(" Resized sucessfully!");
	    }
		
	 //   @Test
		public void TC002() throws InterruptedException, AWTException, IOException
		{
			//Step 3
			Reporter.log("Test case 2");
			Jqueryhome.clickDialogLink();
			//Step 4
			Reporter.log("Clicked on Dialog Link");
			dialoglink.Dialog(dialogname, dialogemail, dialogpassword);
			Reporter.log("DialogLink Page executed sucessfully");
			//step 9
			Jqueryhome.clickSpinnerLink();
			//step 10
			Reporter.log("Clicked on Spinner Link");
			spinnerlink.Spinner();
			Reporter.log("Spinner Page executed sucessfully");
			//step 11
            Jqueryhome.clickTooltipLink();
            Reporter.log("Clicked on Tooltip Link");
            tooltiplink.Tooltip();
            Reporter.log("ToolTip Page executed sucessfully");	
				
		}
		
		//@Test
	    public void TC003() throws InterruptedException, IOException
		{
			//Step 3
			Reporter.log("Test case 3");
			Jqueryhome.clickWidgetFactoryLink();
			//Step 4
			Reporter.log("Clicked on WidgetFactory Link");
			widgetfactorylink.WidgetFactory();
			Reporter.log("WidgetFactory Page executed sucessfully");
	    }		
				
		//@Test
		public void TC004() throws InterruptedException, IOException
		{
			//Step 3
			Reporter.log("Test case 4");
			Jqueryhome.clickColorAnimationLink();
			//Step 4
			Reporter.log("Clicked on ColorAnimation Link");
			coloranimationlink.ColorAnimation();
			Reporter.log("ColorAnimation Page executed sucessfully");
			//step 5
			Jqueryhome.clickEffectLink();
			//step 6
			Reporter.log("Clicked on Effect Link");
			effectpagelink.effect("Effect");
			Reporter.log("Effect Page executed sucessfully");
			//step 7
			Jqueryhome.clickHideLink();
			//step 8
			Reporter.log("Clicked on Hide Link");
			hidepagelink.hide("Hide");
			Reporter.log("Hide Page executed sucessfully");
			//step 9
			Jqueryhome.clickShowLink();
			//step 10
			Reporter.log("Clicked on Show Link");
			showpagelink.show("Show");
			Reporter.log("Show Page executed sucessfully");
	    }		
	
	//	@Test(dataProvider= "getDateData")
		public void TC006(String datepass,String formatselect) throws InterruptedException, ParseException, IOException
		{
			//Step 3
			Reporter.log("Test case 4");
			Jqueryhome.clickDatePickerLink();
			//step 4
			Reporter.log("Clicked on Datepicker Link");
			datepickerlink.Datepicker(datepass, formatselect);
			Reporter.log("Datepicker Page executed sucessfully");
		}
		
		@DataProvider
		public Object [][]getDateData() throws InvalidFormatException
		{
			Object data[][]= DataHandlers.getTestData("TC06");
			return data;
		}
		
	@AfterMethod
	public void postCondition()
	{
	
	driver.close();
	}
	
}
