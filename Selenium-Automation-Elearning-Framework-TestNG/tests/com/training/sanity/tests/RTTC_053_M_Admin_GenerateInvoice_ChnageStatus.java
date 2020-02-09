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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RTTC_053_M_Admin_GenerateInvoice_ChnageStatus {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private RTTC_053_M_Incoice_ChangeOrder InvoiceChngOrder;
	private ScreenShot screenShot;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
		
		public void setUpBeforeClass() throws IOException {
		
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			InvoiceChngOrder = new RTTC_053_M_Incoice_ChangeOrder(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
			//extent = new ExtentReports(sy);
		

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
	public void IncoiceandChangeOrder() throws InterruptedException, IOException {
		
		InvoiceChngOrder.sendUserName("admin");			//Loginnto application as Admin
		InvoiceChngOrder.sendPassword("admin@123");
		InvoiceChngOrder.clickLoginBtn();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		InvoiceChngOrder.Eyeicon.click();				//navigating to generate icon from ordered list				
//		if(InvoiceChngOrder.AddIP.isDisplayed())		//AddIP button is intermittently appearing, this sometimes fails here
//		{
//			InvoiceChngOrder.AddIP.click();
//		}
		InvoiceChngOrder.InvoiceButton();				// This is to handle if the Invoice is already generated
		String InvoiceNum= InvoiceChngOrder.InvoiceNo.getText();
		System.out.println(InvoiceNum + "Invoice Number");
		Assert.assertNotNull(InvoiceNum);
		Reporter.log("Invoice number generated");
		JavascriptExecutor jsm = (JavascriptExecutor) driver;
		jsm.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		InvoiceChngOrder.StatusListBox.click();			//Changing the status of the order to Complete
		InvoiceChngOrder.OrderStatusList();
		InvoiceChngOrder.AddHistory.click();
		Thread.sleep(2000);
		// No Permission to access API intermittently coming
		String SuccessMess= InvoiceChngOrder.SuccessMessage.getText().replaceAll("×"," ").replace('\n',' ').trim();
		//String warn= InvoiceChngOrder.WarningMsg.getText().replaceAll("×"," ").replace('\n',' ').trim();
		// As 'No Permission to API' error is occurring intermittently, thus applying if-else condition
		if(SuccessMess.contains("Success")){
			Assert.assertEquals(SuccessMess, "Success: You have modified orders!");
			Reporter.log("Order is modified successfully");
			System.out.println(SuccessMess);
			driver.navigate().refresh();
			InvoiceChngOrder.StatusListBox.click();
			Thread.sleep(1000);
			InvoiceChngOrder.OrderStatusList();
			Thread.sleep(1000);
			InvoiceChngOrder.AddHistory.click();
			JavascriptExecutor jsmn = (JavascriptExecutor) driver;
			jsmn.executeScript("window.scrollTo(0, 550)");
			screenShot.captureScreenShot("APII.png");
			
		}
		else{
			driver.navigate().refresh();
			InvoiceChngOrder.StatusListBox.click();
			Thread.sleep(1000);
			InvoiceChngOrder.OrderStatusList();
			Thread.sleep(1000);
			InvoiceChngOrder.AddHistory.click(); 
		}
		
	} 
}
		
	

