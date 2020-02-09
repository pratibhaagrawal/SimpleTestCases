package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RTTC_054_M_Admin_PlaceOrderForCustomer {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private RTTC_054_M_Incoice_PlaceOrder PlaceOrder;
	private ScreenShot screenShot;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
		
		public void setUpBeforeClass() throws IOException {
		
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			PlaceOrder = new RTTC_054_M_Incoice_PlaceOrder(driver); 
			baseUrl = properties.getProperty("baseURL");
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
		
		PlaceOrder.sendUserName("admin");				//login to application as Admin
		PlaceOrder.sendPassword("admin@123");
		PlaceOrder.clickLoginBtn();
		Thread.sleep(1000);
		PlaceOrder.SalesIcon.click();					//Navigting to sales icon to order new item for customer
		PlaceOrder.OrderLink.click();
		PlaceOrder.AddNew.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		PlaceOrder.FirstName.sendKeys("Pratibha");		// Entreing customer's details
		PlaceOrder.LastName.sendKeys("Agrawal");
		PlaceOrder.email.sendKeys("pratibha@gmail.com");
		PlaceOrder.Telephone.sendKeys("1111111111");
		Thread.sleep(1000);
		PlaceOrder.Continue.click();
		Thread.sleep(1000);
		PlaceOrder.Product.sendKeys("Asus");			// Entering product details that customer wants to order
		PlaceOrder.Quantity.sendKeys("1");
		PlaceOrder.AddProduct.click();
		PlaceOrder.Cont.click();
		PlaceOrder.FName.sendKeys("Pratibha");			// Providing cuatomer's details in the order form
		PlaceOrder.LName.sendKeys("Agrawal");
		PlaceOrder.Add1.sendKeys("Test 1");
		PlaceOrder.Add2.sendKeys("Test 2");
		PlaceOrder.City.sendKeys("Pune");
		PlaceOrder.PostCode.sendKeys("411001");
		PlaceOrder.CountryName();
		PlaceOrder.StateName();
		PlaceOrder.ContToPay.click();					// for making payment
		if(PlaceOrder.ShippingMethod.isEnabled())		// applying if-else to handle conditions where in the required product is  currently in stock or not 
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
		}
		
	} 
}
		
	

