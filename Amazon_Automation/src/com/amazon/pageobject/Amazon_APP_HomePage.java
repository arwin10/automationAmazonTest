package com.amazon.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.util.Log;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Amazon_APP_HomePage {

	
	private static MobileElement element = null;
	
	public static WebElement button_Signin(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.amazon.mShop.android.shopping:id/sign_in_button");

		if(element.isDisplayed())
		{   
			Log.info("Signin button is displayed.");
			System.out.println("Signin button is displayed.");
			

		}
		else
		{
			Log.warn("Signin button is not displayed.");
			System.out.println("Signin button is not displayed.");
			Assert.assertTrue(false);

		}

		return element;

	}

	public static WebElement txtbx_UserName(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("ap_email_login");

		if(element.isDisplayed())
		{   
			Log.info("Username Textbox is displayed.");
			System.out.println("Username textbox is displayed.");

		}
		else
		{
			Log.warn("Username Textbox is not displayed.");
			System.out.println("Username textbox is not displayed.");
			Assert.assertTrue(false);

		}

		return element;

	}

	public static MobileElement txtbx_Password(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("ap_password");

		if(element.isDisplayed())
		{   
			Log.info("Password Textbox is displayed.");
			System.out.println("Password textbox is displayed.");

		}
		else
		{
			Log.warn("Password Textbox is not displayed.");
			System.out.println("Password textbox is not displayed.");
			Assert.assertTrue(false);

		}

		return element;

	}

	public static MobileElement btn_continue(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("continue");

		if(element.isDisplayed())
		{   
			Log.info("Login continue button is displayed.");
			System.out.println("Login continue button is displayed.");

		}
		else
		{
			Log.warn("Login continue button is not displayed.");
			System.out.println("Login continue button is not displayed.");
			Assert.assertTrue(false);
			
		}

		return element;

	}
	
	
	public static MobileElement btn_Login(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("signInSubmit");

		if(element.isDisplayed())
		{   
			Log.info("Login button is displayed.");
			System.out.println("Login button is displayed.");

		}
		else
		{
			Log.warn("Login button is not displayed.");
			System.out.println("Login button is not displayed.");
			Assert.assertTrue(false);
		}

		return element;

	}
	
	public static MobileElement icon_hamburger(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.amazon.mShop.android.shopping:id/action_bar_burger_icon");

		if(element.isDisplayed())
		{   
			Log.info("Hamburger icon is displayed.");
			System.out.println("Hamburger icon is displayed.");

		}
		else
		{
			Log.warn("Hamburger icon is not displayed.");
			System.out.println("Hamburger icon is not displayed.");
			Assert.assertTrue(false);

		}

		return element;

	}
	
	public static MobileElement btn_Settings(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/btn_save");

		if(element.isDisplayed())
		{   
			Log.info("Settings button is displayed.");
			System.out.println("Settings button is displayed.");

		}
		else
		{
			Log.warn("Settings button is not displayed.");
			System.out.println("Settings button is not displayed.");
			Assert.assertTrue(false);

		}

		return element;

	}
	
	public static MobileElement txtBox_Search(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.amazon.mShop.android.shopping:id/rs_search_src_text");

		if(element.isDisplayed())
		{   
			Log.info("Search textbox is displayed.");
			System.out.println("Search textbox is displayed.");

		}
		else
		{
			Log.warn("Search textbox is not displayed.");
			System.out.println("Search textbox is not displayed.");
			Assert.assertTrue(false);

		}

		return element;

	}
	
	public static MobileElement header_amazon(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.amazon.mShop.android.shopping:id/action_bar_home_logo");

		if(element.isDisplayed())
		{   
			Log.info("Header amazon is displayed.");
			System.out.println("Header amazon is displayed.");

		}
		else
		{
			Log.warn("Header amazon is not displayed.");
			System.out.println("Header amazon is not displayed.");
			Assert.assertTrue(false);

		}

		return element;

	}
	
	public static MobileElement button_location2(AndroidDriver driver){

		element = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView");

		if(element.isDisplayed())
		{   
			Log.info("Location2 Button is displayed.");
			System.out.println("Location2 Button is displayed.");

		}
		else
		{
			Log.warn("Location2 Button is not displayed.");
			System.out.println("Location2 Button is not displayed.");

		}

		return element;

	}
	
	public static MobileElement button_DirectSales(AndroidDriver driver){

		element = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView");

		if(element.isDisplayed())
		{   
			Log.info("DirectSales Button is displayed.");
			System.out.println("DirectSales Button is displayed.");

		}
		else
		{
			Log.warn("DirectSales Button is not displayed.");
			System.out.println("DirectSales Button is not displayed.");

		}

		return element;

	}
	
	public static MobileElement field_Search(AndroidDriver driver){

		element = (MobileElement) driver.findElementByAccessibilityId("Search");

		if(element.isDisplayed())
		{   
			Log.info("Field search is displayed.");
			System.out.println("Field search is displayed.");

		}
		else
		{
			Log.warn("Field search is not displayed.");
			System.out.println("Field search is not displayed.");

		}

		return element;

	}
	
	public static MobileElement div_SearchResult(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/layout_container");

		if(element.isDisplayed())
		{   
			Log.info("Search Result is displayed.");
			System.out.println("Search Result is displayed.");

		}
		else
		{
			Log.warn("Search Result is not displayed.");
			System.out.println("Search Result is not displayed.");

		}

		return element;

	}
	
	public static MobileElement label_SearchResult_OrderID(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/textView_order_no");

		if(element.isDisplayed())
		{   
			Log.info("Search Result Order ID is displayed.");
			System.out.println("Search Result Order ID is displayed.");

		}
		else
		{
			Log.warn("Search Result Order ID is not displayed.");
			System.out.println("Search Result Order ID is not displayed.");

		}

		return element;

	}
	
	public static MobileElement chkBox_RememberMe(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/checkbox_remember_me");

		if(element.isDisplayed())
		{   
			Log.info("RememberMe checkbox is displayed.");
			System.out.println("RememberMe checkbox is displayed.");

		}
		else
		{
			Log.warn("RememberMe checkbox is not displayed.");
			System.out.println("RememberMe checkbox is not displayed.");

		}

		return element;

	}
	
	
	public static MobileElement label_QuickSale(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/action_quick_sale");

		if(element.isDisplayed())
		{   
			Log.info("QuickSale Icon is displayed.");
			System.out.println("QuickSale Icon is displayed.");

		}
		else
		{
			Log.warn("QuickSale Icon is not displayed.");
			System.out.println("QuickSale Icon is not displayed.");

		}

		return element;

	}
	
	public static MobileElement label_ManualSimScan(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/scan_sim_manually_action_txt");

		if(element.isDisplayed())
		{   
			Log.info("label_ManualSimScan Icon is displayed.");
			System.out.println("label_ManualSimScan Icon is displayed.");

		}
		else
		{
			Log.warn("label_ManualSimScan Icon is not displayed.");
			System.out.println("label_ManualSimScan Icon is not displayed.");

		}

		return element;

	}
	
	public static MobileElement txtBox_ICCID(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/edite_text_manually_action_txt");

		if(element.isDisplayed())
		{   
			Log.info("ICCID textbox is displayed.");
			System.out.println("ICCID textbox is displayed.");

		}
		else
		{
			Log.warn("ICCID textbox is not displayed.");
			System.out.println("ICCID textbox is not displayed.");

		}

		return element;

	}
	
	public static MobileElement label_SimConsumedError(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/scanning");

		if(element.isDisplayed())
		{   
			Log.info("SimConsumedError label  is displayed.");
			System.out.println("SimConsumedError label  is displayed.");

		}
		else
		{
			Log.warn("SimConsumedError label  is not displayed.");
			System.out.println("SimConsumedError label  is not displayed.");

		}

		return element;

	}
	
	public static MobileElement label_MobileNumber(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/sim_no_txtView");

		if(element.isDisplayed())
		{   
			Log.info("MobileNumber label  is displayed.");
			System.out.println("MobileNumber label  is displayed.");

		}
		else
		{
			Log.warn("MobileNumber label  is not displayed.");
			System.out.println("MobileNumber label  is not displayed.");

		}

		return element;

	}
	
	public static MobileElement txtbox_IDCustomer(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/id_no_editTxt");

		if(element.isDisplayed())
		{   
			Log.info("Customer ID txtbox  is displayed.");
			System.out.println("Customer ID txtbox  is displayed.");

		}
		else
		{
			Log.warn("Customer ID txtbox  is not displayed.");
			System.out.println("Customer ID txtbox  is not displayed.");

		}

		return element;

	}
	
	public static MobileElement label_CustomerIDType(AndroidDriver driver){

		element = (MobileElement) driver.findElementById("com.ntgclarity.adm:id/input_id_type_txt");

		if(element.isDisplayed())
		{   
			Log.info("CustomerIDType label  is displayed.");
			System.out.println("CustomerIDType label  is displayed.");

		}
		else
		{
			Log.warn("CustomerIDType label  is not displayed.");
			System.out.println("CustomerIDType label  is not displayed.");

		}

		return element;

	}
	
	
}
