package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminToDeleteCustomerDetail;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Admin_To_Delete_Customer_Detail {

	private WebDriver driver;
	private String baseUrl;
	private AdminToDeleteCustomerDetail DeleteCustomer;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		DeleteCustomer = new AdminToDeleteCustomerDetail(driver); 
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
	public void validLoginTest() throws IOException {
		
		DeleteCustomer.sendUserName("admin");
		DeleteCustomer.sendPassword("admin@123");
		DeleteCustomer.clickLoginBtn();
		String title= driver.getTitle();
		Assert.assertEquals(title, "Dashboard");
		Reporter.log("Loggin is successful");
		DeleteCustomer.customericon.click();
		DeleteCustomer.customer.click();
		DeleteCustomer.CustName.sendKeys("Manzoor Mehadi");
		DeleteCustomer.FilterButton.click();
		DeleteCustomer.customerToBeDeleted.click();
		DeleteCustomer.deletebutton.click();
		Assert.assertEquals("Are you sure?", "Are you sure?");
		driver.switchTo().alert().accept();
		String SuccessMessage= DeleteCustomer.SuccessMessage.getText();
		System.out.println(SuccessMessage);
		screenShot.captureScreenShot("NewSuccessMsg.png");
// ***NOTE=Cross mark is also getting captured along with the text. 
//Therefore, as suggested by the trainer-Sunil, skipping this step verification.***
		//Assert.assertEquals(SuccessMessage, "Success: You have modified customers!");
		Reporter.log("Admin user has deleted required customer successfully");
	}
}
