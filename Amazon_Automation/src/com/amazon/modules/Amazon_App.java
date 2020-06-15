package com.amazon.modules;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.pageobject.Amazon_APP_HomePage;
import com.amazon.util.CommonUtilities;
import com.amazon.util.DataBaseUtilities;
import com.amazon.util.ExcelUtilities;
import com.amazon.util.Log;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Amazon_App {
	
	private AndroidDriver driver;
	private CommonUtilities utilities;
	private DataBaseUtilities dbutilities;
	private WebDriverWait wait;
	private String sTestCaseName;
	private int iTestCaseRow;
	ArrayList moduleRecord=null;
	ResultSet tableRecord = null;
	public static String userName = "arindamsarkar1";
	public static String accessKey = "7spxzgibvxvuqZNseQUM";


	@BeforeTest
	@Parameters("browsername")
	public void setUp(String browsername) throws Exception{

		//Log4j configuration settings
		DOMConfigurator.configure("log4j.xml");
		Log.info("Log4j initiated");

		System.out.println("Executing in browser: "+browsername);
	
		if(browsername.equalsIgnoreCase("Android_Device"))	
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "Mi A1");
			capabilities.setCapability("platformVersion", "9");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
			capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			//capabilities.setCapability("no-Reset", "false");
			capabilities.setCapability("full-Reset", "true");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
		
		
		Log.info("Android driver instantiated.");
        System.out.println("-------->Android driver instantiated.");

		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		

        if(driver.isDeviceLocked())
        {
        	System.out.println("Device Locked..Unlocking..");
        	driver.unlockDevice();
        	
        }
        else
        {
        	System.out.println("Device UnLocked..Launching App..");
        }

		wait = new WebDriverWait(driver,60);
		Log.info("WebDriver wait initialized.");
		System.out.println("-------->WebDriver wait initialized.");
		utilities = new CommonUtilities();
		//dbutilities= new DataBaseUtilities();


		//Getting Testdata from the excel file
		moduleRecord=ExcelUtilities.excelSetDBRecord("Jawwy_ADM_APP");
		//dbutilities.DatabaseConnection_SSO();


	}

	@AfterTest
	public void tearDown() throws Exception{

		driver.quit();
	}
	
	
	@Test
	@Parameters("testcasename")
	public void verify_AmazonOrderPlacement(String testcasename) throws Exception{

		try
		{
			System.out.println("Getting testdata for testcase:"+testcasename);


			Map testdata = ExcelUtilities.getTestData(testcasename);

			Log.startTestCase(testcasename);

			utilities.appAmazon_Login(driver, testdata.get("URL").toString(),testdata.get("UserName").toString(), testdata.get("Password").toString());
			
			if(Amazon_APP_HomePage.header_amazon(driver).isDisplayed())
			{
				Log.info("Amazon App HomePage is opened.");
				System.out.println("Amazon App HomePage is opened.");
				
				Amazon_APP_HomePage.txtBox_Search(driver).sendKeys("TV");
				Thread.sleep(5000);
			}
			else
			{
				Log.warn("Amazon App HomePage is not opened.");
				System.out.println("Amazon App HomePage is not opened.");
				Assert.assertTrue(false);
			}
			
			Log.endTestCase(testcasename);

		}


		catch(Exception e)
		{
			System.out.println("Exception Occured:"+e);
			Log.error(e.getMessage());
			Assert.assertTrue(false);
		}

	}
    
	
}
