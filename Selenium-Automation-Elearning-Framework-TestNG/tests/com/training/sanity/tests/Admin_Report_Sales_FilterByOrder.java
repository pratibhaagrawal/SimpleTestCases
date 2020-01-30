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
import com.training.pom.AdminToFilterSalesOrder;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Admin_Report_Sales_FilterByOrder {

	private WebDriver driver;
	private String baseUrl;
	private AdminToFilterSalesOrder FilterSalesOrder;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
		
		public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			FilterSalesOrder = new AdminToFilterSalesOrder(driver); 
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
		
		FilterSalesOrder.sendUserName("admin");
		FilterSalesOrder.sendPassword("admin@123");
		FilterSalesOrder.clickLoginBtn();
		String title= driver.getTitle();
		Assert.assertEquals("Dashboard", title);
		Reporter.log("Loggin is successful");
		FilterSalesOrder.Report.click();
		FilterSalesOrder.Sales.click();
		FilterSalesOrder.Orders.click();
		FilterSalesOrder.GrpByFilter.click();
		Thread.sleep(2000);
		screenShot.captureScreenShot("Dropdownlist.png");
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
		System.out.println("Group by list contains all required fields");
		dropdown.selectByValue("week");
		Thread.sleep(2000);		
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Weeks");
		FilterSalesOrder.FilterButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		screenShot.captureScreenShot("NewWeeklyOrder.png");
		System.out.println("Weekly order screenshot captured");
		Reporter.log("Weekly order screenshot captured has been verified");
	}
}
