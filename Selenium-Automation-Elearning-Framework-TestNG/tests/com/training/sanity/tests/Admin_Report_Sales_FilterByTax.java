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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Admin_Report_Sales_FilterByTax {

	private WebDriver driver;
	private String baseUrl;
	private AdminToFilterTaxOrder FilterTaxOrder;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
		
		public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			FilterTaxOrder = new AdminToFilterTaxOrder(driver); 
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
		
		FilterTaxOrder.sendUserName("admin");
		FilterTaxOrder.sendPassword("admin@123");
		FilterTaxOrder.clickLoginBtn();
		String title= driver.getTitle();
		Assert.assertEquals("Dashboard", title);
		Reporter.log("Loggin is successful");
		FilterTaxOrder.Report.click();
		FilterTaxOrder.Sales.click();
		String Ord=FilterTaxOrder.Orders.getText();
		Assert.assertEquals(Ord, "Orders");
		String Ship= FilterTaxOrder.Shipping.getText();
		Assert.assertEquals(Ship, "Shipping");
		String Ret=FilterTaxOrder.Returns.getText();
		Assert.assertEquals(Ret, "Returns");
		String Cou=FilterTaxOrder.Coupons.getText();
		Assert.assertEquals(Cou, "Coupons");
		System.out.println("Sales section contain all the subsections-Order, tax, Shipping, Returns, Coupons");
		Reporter.log("Sales section contain all the subsections-Order, tax, Shipping, Returns, Coupons");
		FilterTaxOrder.Tax.click();
		FilterTaxOrder.GrpByFilter.click();
		Select dropdown = new Select(driver.findElement(By.id("input-group")));
		List<WebElement> count= dropdown.getOptions();
		int listsize=count.size();
		String[] exp= {"Years", "Months", "Weeks", "Days"};
		for (WebElement act:count)
		{
			for (int i=0; i<listsize; i++)
			{
				if(act.getText().equals(exp[i]))
				{
					Reporter.log("Group by list contains all required fields");
				}
			}
		}
		dropdown.selectByValue("week");
		Thread.sleep(2000);		
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Weeks");
		FilterTaxOrder.FilterButton.click();
		screenShot.captureScreenShot("WeeklytaxOrder1.png");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		screenShot.captureScreenShot("WeeklytaxOrder2.png");
//*** By default the result is displayed with GrpBy=Weekly, thus capturing screenshots***
		System.out.println("Weekly Tax order screenshots captured");
		Reporter.log("Weekly Tax order screenshots captured has been verified");
	}
}
