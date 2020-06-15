package com.amazon.util;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.pageobject.Amazon_APP_HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidDriver;


public class CommonUtilities {


	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(fileName)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}


	public void explicitilyWaitFor(String xpath,WebDriverWait wait) throws Exception{

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

	}
	
	public void switchCurrentWindow(WebDriver driver) throws Exception{

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

	}
	
	public void explicitilyWaitForPresence(String xpath,WebDriverWait wait) throws Exception{

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

	}

	public void scrollIntoView(WebDriver driver,String path) throws Exception
	{
		WebElement element=driver.findElement(By.xpath(path));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		//je.executeScript("window.scrollBy(0,-120)", "");
	}

	public void scrollDown(WebDriver driver, String path)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,-120)","");
	}
	
	public void stopPageLoading(WebDriver driver)
	{
		driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return window.stop");
	}


	public boolean isElementPresent(WebDriver driver, String xpath) 
	{
		if(driver.findElements(By.xpath(xpath)).size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

		
	public void appAmazon_Login(AndroidDriver driver,String appURL,String username,String password) throws Exception
	{


		System.out.println("Launching Amazon_APP --->");
		
		Amazon_APP_HomePage.button_Signin(driver).click();
		//Amazon_APP_HomePage.txtbx_UserName(driver).click();
		//(new TouchAction(driver)).tap(PointOption.point(158, 559)).perform();
		Amazon_APP_HomePage.txtbx_UserName(driver).sendKeys("xxxxx@gmail.com");
		Amazon_APP_HomePage.btn_continue(driver).click();
		//(new TouchAction(driver)).tap(PointOption.point(158, 559)).perform();

		Amazon_APP_HomePage.txtbx_Password(driver).sendKeys("xxxxxx");
		Amazon_APP_HomePage.btn_Login(driver).click();

		System.out.println("Logging into Amazon_APP Application--->");


	}

	

}
