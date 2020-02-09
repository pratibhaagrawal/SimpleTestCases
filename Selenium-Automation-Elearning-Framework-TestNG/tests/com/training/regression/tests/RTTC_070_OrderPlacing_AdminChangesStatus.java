package com.training.regression.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.training.generics.ScreenShot;
import com.training.pom.AdminToDeleteCustomerDetail;
import com.training.pom.AdminToFilterTaxOrder;
import com.training.pom.LoginPOM;
import com.training.pom.Medium_CreateNewGrpAndRegisterUser;
import com.training.pom.RTTC_052_M_RewardPts;
import com.training.pom.RTTC_053_M_Incoice_ChangeOrder;
import com.training.pom.RTTC_054_M_Incoice_PlaceOrder;
import com.training.pom.RTTC_070;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RTTC_070_OrderPlacing_AdminChangesStatus {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private RTTC_070 Order;
	private ScreenShot screenShot;



	@BeforeTest
		
		public void setUpBeforeClass() throws IOException {
		
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			Order = new RTTC_070(driver); 
			baseUrl = properties.getProperty("URL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		

	}

	/*@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	} */
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test 
	public void PlaceOrder() throws InterruptedException, IOException {
		
		
		Order.SearchBar.click();
		
		//Order.Keyword.click();
		Order.KeyWordSearch();
		Order.Keyword.sendKeys("Finger Ring5");
		Order.Keyword.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		//Order.KeyWordSearchResult();
		Order.Ring.click();
		Order.AddToCart.click();
		Thread.sleep(1000);
		screenShot.captureScreenShot("pop_up.png");
//		try {
//			Alert carted = driver.switchTo().alert();
//			String alertText= carted.getText();
//			System.out.println(alertText);
//		}
//		catch(NoAlertPresentException e) {
//	        e.printStackTrace();
//		}
		Thread.sleep(10000);
		Order.CartIcon();
		Thread.sleep(2000);
		Order.checkout.click();
		//Order.CheckOutIcon();
		Order.email.click();
		Order.email.sendKeys("pratibha_ele123@gmail.com");
		Order.password.click();
		Order.password.sendKeys("test@123");
		Order.loggin.click();
		Order.addressConti.click();
		Order.shippingConti.click();
		//Order.comment.click();
		//Order.comment.sendKeys("this is nice");
		Order.FreeConti.click();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0, 350)");
		Order.Iagree.click();
		Order.payConti.click();
		Order.confirm.click();

		
		
		
		
		
		
		
		
		
		
		
		

		
		/*Thread.sleep(1000);
		PlaceOrder.SalesIcon.click();
		PlaceOrder.OrderLink.click();
		PlaceOrder.AddNew.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		PlaceOrder.FirstName.sendKeys("Pratibha");
		PlaceOrder.LastName.sendKeys("Agrawal");
		PlaceOrder.email.sendKeys("pratibha@gmail.com");
		PlaceOrder.Telephone.sendKeys("1111111111");
		Thread.sleep(2000);
		PlaceOrder.Continue.click();
		Thread.sleep(4000);
		PlaceOrder.Product.sendKeys("Asus");
		PlaceOrder.Quantity.sendKeys("1");
		PlaceOrder.AddProduct.click();
		PlaceOrder.Cont.click();
		PlaceOrder.FName.sendKeys("Pratibha");
		PlaceOrder.LName.sendKeys("Agrawal");
		PlaceOrder.Add1.sendKeys("Test 1");
		PlaceOrder.Add2.sendKeys("Test 2");
		PlaceOrder.City.sendKeys("Pune");
		PlaceOrder.PostCode.sendKeys("411001");
		PlaceOrder.CountryName();
		PlaceOrder.StateName();
		PlaceOrder.ContToPay.click();
		if(PlaceOrder.ShippingMethod.isEnabled())
		{
			PlaceOrder.ShipMode();
			PlaceOrder.PaymentMode();
			PlaceOrder.Save.click();
			String SuccessMess= PlaceOrder.SuccessMessage.getText().replaceAll("×"," ").replace('\n',' ').trim();
			Assert.assertEquals(SuccessMess, "Success: You have modified orders!");
			Reporter.log("Success: You have modified orders!");
		}
		else
		{
			PlaceOrder.PaymentModeElse();
			System.out.println("Warning: Products marked with *** are not available in the desired quantity or not in stock!");
			Reporter.log("Products marked with *** are not available");
		} */
		
	} 
}
		
	

