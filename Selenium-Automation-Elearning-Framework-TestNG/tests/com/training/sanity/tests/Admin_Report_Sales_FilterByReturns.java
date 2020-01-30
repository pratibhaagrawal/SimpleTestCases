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
import com.training.pom.Admin_Report_FilterByReturns;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Admin_Report_Sales_FilterByReturns {

	private WebDriver driver;
	private String baseUrl;
	private Admin_Report_FilterByReturns FilterByReturns;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
		
		public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			FilterByReturns = new Admin_Report_FilterByReturns(driver); 
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
		
		FilterByReturns.sendUserName("admin");
		FilterByReturns.sendPassword("admin@123");
		FilterByReturns.clickLoginBtn();
		String title= driver.getTitle();
		Assert.assertEquals("Dashboard", title);
		Reporter.log("Loggin is successful");
		FilterByReturns.Report.click();
		FilterByReturns.Sales.click();
		FilterByReturns.Returns.click();
		String header = FilterByReturns.RetHead.getText();
		Assert.assertEquals(header, "Returns List");
		FilterByReturns.GrpByFilter.click();
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
		FilterByReturns.FilterButton.click();
		String ResTxt=FilterByReturns.ResultText.getText();
		if(ResTxt.contains("No. Returns")){
			System.out.println("There are no items returned this week");
			Reporter.log("There are no items returned this week");
		}
		else{
			screenShot.captureScreenShot("WeeklyReturns1.png");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			screenShot.captureScreenShot("WeeklyReturns2.png");
		}
	}
}
