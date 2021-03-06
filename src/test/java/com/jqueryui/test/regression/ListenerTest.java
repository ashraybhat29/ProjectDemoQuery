package com.jqueryui.test.regression;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.jqueryui.lib.util.Utility;		

public class ListenerTest implements ITestListener						
{		
	Utility utility = new Utility();
	WebDriver driver;
    
    public void onFinish(ITestContext Result) 					
    {		
                		
    }		

    
    public void onStart(ITestContext Result)					
    {		
            		
    }		

    
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    		
    }		

    // When Test case get failed, this method is called.		
    
//    public void onTestFailure(ITestResult Result)				
//    {		
//         try {
//        	 utility.captureScreenshot(driver, "error in page");
//         }catch(IOException e)
//         {
//        	 e.printStackTrace();
//         } catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }		

    // When Test case get Skipped, this method is called.		
    
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
    }		

    // When Test case get Started, this method is called.		
    
    public void onTestStart(ITestResult Result)					
    {		
    System.out.println(Result.getName()+" test case started");					
    }		

    // When Test case get passed, this method is called.		
    
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The name of the testcase passed is :"+Result.getName());					
    }		

}		