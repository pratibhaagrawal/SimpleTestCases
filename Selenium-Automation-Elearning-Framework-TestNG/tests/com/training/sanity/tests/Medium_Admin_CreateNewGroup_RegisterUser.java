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

import com.training.generics.ScreenShot;
import com.training.pom.AdminToDeleteCustomerDetail;
import com.training.pom.AdminToFilterTaxOrder;
import com.training.pom.LoginPOM;
import com.training.pom.Medium_CreateNewGrpAndRegisterUser;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium_Admin_CreateNewGroup_RegisterUser {

	private WebDriver driver;
	private String baseUrl;
	private Medium_CreateNewGrpAndRegisterUser NewGrpRegisteruser;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
		
		public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			NewGrpRegisteruser = new Medium_CreateNewGrpAndRegisterUser(driver); 
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
	public void SortOrder() throws InterruptedException, IOException {
		
		NewGrpRegisteruser.sendUserName("admin");		//Login to application as Admin
		NewGrpRegisteruser.sendPassword("admin@123");
		NewGrpRegisteruser.clickLoginBtn();
		NewGrpRegisteruser.customericon.click();		//Go to customer icon and then cust grp
		NewGrpRegisteruser.CustGrp.click();				//Add a new user to a group
		NewGrpRegisteruser.AddButton.click();
		NewGrpRegisteruser.GrpName.sendKeys("privileged customer");
		NewGrpRegisteruser.Desc.sendKeys("privileged customer");
		NewGrpRegisteruser.ApproveYes.click();
		NewGrpRegisteruser.SaveNewCust.click();
		String SuccessMess= NewGrpRegisteruser.SuccessMessage.getText().replaceAll("×"," ").replace('\n',' ').trim();
		System.out.println(SuccessMess);
		screenShot.captureScreenShot("CustGrpAdded.png");
		Assert.assertEquals(SuccessMess, "Success: You have modified customer groups!");
		
		Thread.sleep(2000);
		NewGrpRegisteruser.customericon.click();
		NewGrpRegisteruser.Custlink.click();
		NewGrpRegisteruser.AddCust.click();
		//Add cust page displays
		NewGrpRegisteruser.privilegedCustGrp();
		NewGrpRegisteruser.FirstName.sendKeys("manzoormanzoor");
		NewGrpRegisteruser.LastName.sendKeys("mehadimehadi");
		NewGrpRegisteruser.email.sendKeys("manzoor.changedid@gmail.com");
		NewGrpRegisteruser.tele.sendKeys("9551233111");
		NewGrpRegisteruser.enterpassword.sendKeys("manzoornew");
		NewGrpRegisteruser.confpassword.sendKeys("manzoornew");
		NewGrpRegisteruser.AddAddress.click();
		NewGrpRegisteruser.firstname1.sendKeys("manzoorNew");
		NewGrpRegisteruser.lastname1.sendKeys("mehadiNew");
		NewGrpRegisteruser.Address1.sendKeys("yeshwanthapur");
		NewGrpRegisteruser.Address2.sendKeys("bangalore");
		NewGrpRegisteruser.City.sendKeys("bangalore");
		NewGrpRegisteruser.postcode.sendKeys("560022");
		NewGrpRegisteruser.CountryName();
		NewGrpRegisteruser.RegionName();
		NewGrpRegisteruser.SaveNewCust.click();
		
		//the below code is to handle when the warning message when as existing customer is getting added into the system
		
		String warn= NewGrpRegisteruser.WarningMsg.getText().replaceAll("×"," ").replace('\n',' ').trim();
		if(warn.contains("Warning")){
			System.out.println(warn + "\n As the customer details already exists therefore it can not be added");
			Assert.assertEquals(warn, "Warning: E-Mail Address is already registered!");
			Reporter.log("The customer details already exists");
			screenShot.captureScreenShot("warn1.png");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			screenShot.captureScreenShot("warn2.png");
		}
		else{
			String SuccessMessage1= NewGrpRegisteruser.SuccessMessage.getText().replaceAll("×"," ").replace('\n',' ').trim();
			System.out.println(SuccessMessage1);
			Assert.assertEquals(SuccessMessage1, "Success: You have modified customer groups!");
			Reporter.log("The customer group has been successfully modified");
			screenShot.captureScreenShot("Message.png");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			screenShot.captureScreenShot("Message1.png");
		}

		
	}
}
		
	

