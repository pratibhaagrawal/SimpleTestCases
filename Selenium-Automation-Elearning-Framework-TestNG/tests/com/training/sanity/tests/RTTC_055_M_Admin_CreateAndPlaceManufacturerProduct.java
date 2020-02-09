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

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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
import com.training.pom.RTTC_055_M_ManufacturerProduct;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RTTC_055_M_Admin_CreateAndPlaceManufacturerProduct {
	//private log loginPOM; still facing issues with INHERITACE, I'll need your help to fix them.
	//meanwhile proceeding the TCs without inheritance 
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	public RTTC_055_M_ManufacturerProduct ManuProd;
	public ScreenShot screenShot;
	
	@BeforeTest
		
		public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			ManuProd = new RTTC_055_M_ManufacturerProduct(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
			//RTTC_055_M_Admin_CreateAndPlaceManufacturerProduct mp =new RTTC_055_M_Admin_CreateAndPlaceManufacturerProduct();
			//mp.userLoginTest();
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
//		ManuProd = new RTTC_055_M_ManufacturerProduct(driver); 
//		RTTC_055_M_Admin_CreateAndPlaceManufacturerProduct mp =new RTTC_055_M_Admin_CreateAndPlaceManufacturerProduct();
//		mp.userLoginTest();
		
		ManuProd.sendUserName("admin");  		//login to application as Admin
		ManuProd.sendPassword("admin@123");
		ManuProd.clickLoginBtn();
		Thread.sleep(1000);
		ManuProd.Catalog.click(); 				// Navigate to catelog icon
		ManuProd.Manufacturer.click();			// Navigate to manufacturer link under catelog
		ManuProd.AddNew.click();				// Add new to add new manufacturer details
		ManuProd.ManuName.sendKeys("Pratibha");
		ManuProd.Save.click();
		String SuccessMess= ManuProd.SuccessMessage.getText().replaceAll("×"," ").replace('\n',' ').trim();
		Assert.assertEquals(SuccessMess, "Success: You have modified manufacturers!");
		screenShot.captureScreenShot("Manufacturer.png");
		Reporter.log("Success: You have modified manufacturers!");
		Thread.sleep(1000);
		ManuProd.Dashboard.click();				//Navigating to dashboard before again going to catalog link
		Thread.sleep(1000);
		ManuProd.Catalog.click();
		ManuProd.Product.click();				//Adding  new product and filling all required details
		ManuProd.AddNew.click();
		ManuProd.ProductName.sendKeys("Finger Ring");
		ManuProd.MetaTag.sendKeys("Finger Ring for ladies");
		ManuProd.DataTab.click();
		ManuProd.Model.sendKeys("SKU-012");
		ManuProd.Price.sendKeys("500");
		ManuProd.Quantity.sendKeys("50");
		ManuProd.Linktab.click();
		ManuProd.ManuText.sendKeys("Pratibha");
		ManuProd.CatagoryList.click();
		ManuProd.CatagoryList.sendKeys("Earing");
		ManuProd.SaveFinal.click();					//Saving the product added and verifying confirmation message in below steps
		String Success= ManuProd.SuccessMessage.getText().replaceAll("×"," ").replace('\n',' ').trim();
		Assert.assertEquals(Success, "Success: You have modified products!");
		screenShot.captureScreenShot("product.png");
		Reporter.log("Success: You have modified products!");
		
	} 
}
		
	

