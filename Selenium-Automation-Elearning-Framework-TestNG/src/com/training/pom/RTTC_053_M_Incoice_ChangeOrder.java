package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_053_M_Incoice_ChangeOrder {
	private WebDriver driver; 
	
	public RTTC_053_M_Incoice_ChangeOrder(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div[@class='alert alert-success']") 
	public WebElement SuccessMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	public WebElement WarningMsg;

	@FindBy(xpath="//tr[1]//td[6]//a[1]") 
	public WebElement Eyeicon;
	
	@FindBy(xpath="//tr[1]//td[3]//button[1]") 
	public WebElement GenerateInvoice;
	
	@FindBy(xpath="//td[@id='invoice']") 
	public WebElement InvoiceNo;
	
	@FindBy(id="input-order-status") 
	public WebElement StatusListBox;
	
	@FindBy(id="button-history") 
	public WebElement AddHistory;
	
	@FindBy(id="button-ip-add") 
	public WebElement AddIP;	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
		
	/*public void LatestOrder() {
		//this.LatestOrderTable.click();
		int rowcount = LatestOrderTable.findElements(By.cssSelector("text-right")).size();
		int status = LatestOrderTable.findElements(By.xpath("//tbody//tr//td[3]")).size();
		for (int i=0;i<status; i++)
		{
			WebElement j= LatestOrderTable.findElements(By.xpath("//tbody//tr//td[3]")).get(i);
			System.out.println(j);
				
		} */
	public void OrderStatusList() {
		this.StatusListBox.click(); 
		Select dropdown= new Select (driver.findElement(By.id("input-order-status")));
		dropdown.selectByVisibleText("Complete");
	}
		
	public void InvoiceButton() {
		//this.GenerateInvoice.isEnabled(); 
		if(GenerateInvoice.isEnabled())
		{
			driver.findElement(By.xpath("//tr[1]//td[3]//button[1]")).click();
		}
		else
		{
			
		}
		
	}

}

