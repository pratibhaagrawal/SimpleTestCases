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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RTTC_052_M_Admin_RewardPoints {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_052_M_RewardPts Rewardpts;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeTest
		
		public void setUpBeforeClass() throws IOException {
		
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			Rewardpts = new RTTC_052_M_RewardPts(driver); 
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
	public void RewardPoints() throws InterruptedException, IOException {
		Rewardpts.sendUserName("admin");			//Login to application as Admin
		Rewardpts.sendPassword("admin@123");
		Rewardpts.clickLoginBtn();
		Rewardpts.customericon.click();				// Go to customer icon and then customer link
		Rewardpts.Custlink.click();
		Rewardpts.custName.sendKeys("Manzoor Mehadi"); 		//Enter customer name to search a particular customer
		Rewardpts.filterbtn.click();
		Rewardpts.edit.click();
		Rewardpts.FirstName.clear();
		Rewardpts.FirstName.sendKeys("Asmita");				//Updating the customer Name
		Rewardpts.Address1.click();
		Rewardpts.postcode.click();
		Rewardpts.postcode.clear();
		Rewardpts.postcode.sendKeys("8796545");				//Updating the postcode
		Rewardpts.rewardpt.click();
		Rewardpts.desc.sendKeys("review");
		Rewardpts.points.sendKeys("50");					//Adding reward points
		Rewardpts.Addpoints.click();
		String SuccessMess= Rewardpts.SuccessMessage.getText().replaceAll("×"," ").replace('\n',' ').trim();
		Assert.assertEquals(SuccessMess, "Success: You have modified customers!");
		Reporter.log("Customer modified successfully");
		Rewardpts.savepts.click();
		Rewardpts.report.click();							// Veryfying rewards points added and name change updated successfully in report section
		Rewardpts.reportCust.click();
		Rewardpts.CustPts.click();
		String RewardReport = Rewardpts.pointsMessage.getText();
		Assert.assertEquals(RewardReport, "Customer Reward Points Report");
		screenShot.captureScreenShot("report1.png");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		screenShot.captureScreenShot("report2.png");
		Rewardpts.updatedcust.sendKeys("Asmita mehadi");
		Rewardpts.filterbtn.click();
		String updatedName = Rewardpts.searchresult.getText();
		Assert.assertEquals(updatedName, "Asmita mehadi");

		
	} 
}
		
	

